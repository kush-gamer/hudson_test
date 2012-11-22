package com.mango.games.rummy.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.smartfoxserver.v2.entities.Room;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.Zone;

public class UserHelper
{
	public static List<User> GetUsersExceptUser(Room room, long exceptUser) 
	{
		if(room == null)
		{
			return null;
		}
		
		List<User> users = room.getUserList();
				
		if(exceptUser != 0)
		{
			User usr = GetUserByName(room, exceptUser);
			users.remove(usr);
		}

		return users;
	}

	public static List<User> GetUsersList(Room currentRoom)
	{
		return GetUsersExceptUser(currentRoom, 0);
	}
	
	public static List<User> GetRecipientsExceptUser(Room room, long exceptUser) 
	{
		if(room == null)
		{
			return null;
		}
		
		List<User> users = room.getUserList();
				
		if(exceptUser != 0)
		{
			for(User usr : users)
			{
				if(Long.getLong(usr.getName()) == exceptUser)
				{
					users.remove(usr);
					break;
				}
			}			
		}
		return users;
	}
	
	public static List<User> GetPlayersExceptPlayer(Room room, long exceptUser)
	{
		if(room == null)
		{
			return null;
		}
		
		List<User> users = room.getPlayersList();
		
		if(exceptUser != 0)
		{
			users.remove(exceptUser);
		}

		return users;
	}
	
	public static List<User> GetPlayersList(Room room)
	{
		return GetPlayersExceptPlayer(room, 0);
	}
	
	public static User GetUser(Room currentRoom, int sfsId)
	{
		List<User> userList = UserHelper.GetUsersList(currentRoom);
		
		for(User usr : userList)
		{
			if(sfsId == usr.getId())
			{
				return usr;
			}
		}		
		return null;
	}
	
	public static User GetUserByName(Room currentRoom, long sfsName)
	{
		List<User> userList = UserHelper.GetUsersList(currentRoom);
		
		for(User usr : userList)
		{
			if(sfsName == Long.getLong(usr.getName()))
			{
				return usr;
			}
		}
		
		return null;
	}
	
	public static User GetUserInZone(long fbID, Zone zone)
	{
		for(User usr : zone.getUserList())
		{
			if(fbID == Long.getLong(usr.getName()))
			{
				return usr;
			}
		}
		
		return null;
	}
	
	public static List<User> GetUsersInLobby(Zone zone)
	{
		ArrayList<User> usersInLobby = new ArrayList<User>();

		for(User usr : zone.getUserList())
		{
			if(usr.getLastJoinedRoom() != null)
			{
				continue;
			}
			
			usersInLobby.add(usr);
		}

		return usersInLobby;
	}
	
	public static List<User> GetUsersInLobbyExceptUser(Zone zone, User usr)
	{
		ArrayList<User> usersInLobby = new ArrayList<User>();

		for(User u : zone.getUserList())
		{
			if(u.getLastJoinedRoom() != null || u == usr)
			{
				continue;
			}
			usersInLobby.add(u);
		}

		return usersInLobby;
	}
	
		
	public static ArrayList<User> GetSpectatorList(Room room) 
	{
		ArrayList<User> spectatorList = new ArrayList<User>();
		
		for(User usr : room.getUserList())
		{
			if(usr.isSpectator())
			{
				spectatorList.add(usr);
			}
		}

		return spectatorList;
	}
	
	public static boolean IsEurope(String countryCode)
	{
		List<String> countryCodes = Arrays.asList("DE", "ES", "FR", "IT", "NL", "SE", "AT", "LU", "HU", "PL");
		
		if(countryCodes.contains(countryCode)) return true;
		else return false;
	}
	
	public static void SendDataToAamlytics(String userFBID, String timeStamp)
	{
		HttpURLConnection httpcon;
		try 
		{
			String appKey = "d95dc7dc39c4450eb45789bafa73ef47";
			String apiVersion = "1.0";
			String url = "http://analytics.mangogames.in/" + appKey + "/" + apiVersion + "/ses";
			
			httpcon = (HttpURLConnection)((new URL(url).openConnection()));
			httpcon.setDoInput(true);
			httpcon.setDoOutput(true);
			//httpcon.setRequestProperty("Content-Type", "application/json");
			//httpcon.setRequestProperty("Accept", "application/json");
			httpcon.setRequestMethod("POST");
			httpcon.connect();
			byte[] outputBytes = "{'session':'0','deviceid':'web','gameversion':'2.0.83','userid':'123','timestamp':'123'}".getBytes("UTF-8");
			
			//final String toWriteOut = '{"session": 0, "deviceid": "web", "gameversion" : "2.0.83", "userid":"123","timestamp":"123"}';
			
			//final String toWriteOut = "{'session': 0, 'deviceid': 'web', 'gameversion' : '2.0.83', 'userid':'" + userFBID + "','timestamp':'" + DateTimeUtil.GetCurrentTimeStampinEpoch()+"'}";
			
			OutputStream osw = httpcon.getOutputStream();
			osw.write(outputBytes);
			
			osw.close();
			
			 //Get Response	
		    InputStream is = httpcon.getInputStream();
		    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		    String line;
		    StringBuffer response = new StringBuffer();
		    while((line = rd.readLine()) != null) 
		    {
		    	response.append(line);
		    	response.append('\r');
		    }
			
			rd.close();			
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static String GetUserLocation(User usr)
	{
		String ipAddress = usr.getIpAddress();
		String url =  "http://freegeoip.net/xml/" + ipAddress;
		
		try 
		{
			URL u = new URL(url);
			
			InputStream is = (InputStream) u.openStream();
	        
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = null;
			try 
			{
				docBuilder = docBuilderFactory.newDocumentBuilder();
			} 
			catch (ParserConfigurationException e) 
			{
				e.printStackTrace();
			}

			Document doc = docBuilder.parse(is);
			
			doc.getDocumentElement().normalize();
			
//			System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());
			
			NodeList listOfPersons = doc.getElementsByTagName("CountryName");
			//int totalPersons = listOfPersons.getLength();
			Element firstPersonElement = (Element)listOfPersons.item(0);
			NodeList name = firstPersonElement.getChildNodes();
//			System.out.println("Country name  : " + ((Node)name.item(0)).getNodeValue().trim());
			
			
			listOfPersons = doc.getElementsByTagName("Ip");
			//int totalPersons = listOfPersons.getLength();
			 firstPersonElement = (Element)listOfPersons.item(0);
			 name = firstPersonElement.getChildNodes();
//			System.out.println("Ip  : " + ((Node)name.item(0)).getNodeValue().trim());
			
			listOfPersons = doc.getElementsByTagName("Latitude");
			//int totalPersons = listOfPersons.getLength();
			 firstPersonElement = (Element)listOfPersons.item(0);
			 name = firstPersonElement.getChildNodes();
//			System.out.println("Latitude  : " + ((Node)name.item(0)).getNodeValue().trim());
			
			listOfPersons = doc.getElementsByTagName("Longitude");
			//int totalPersons = listOfPersons.getLength();
			 firstPersonElement = (Element)listOfPersons.item(0);
			 name = firstPersonElement.getChildNodes();
//			System.out.println("Longitude  : " + ((Node)name.item(0)).getNodeValue().trim());			
			
			 listOfPersons = doc.getElementsByTagName("CountryCode");
			//int totalPersons = listOfPersons.getLength();
			 firstPersonElement = (Element)listOfPersons.item(0);
			 name = firstPersonElement.getChildNodes();
			 String countryCode = ((Node)name.item(0)).getNodeValue().trim();
			 
			 return countryCode;
		} 
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		} 
		catch (SAXException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return "US";
	}
}

