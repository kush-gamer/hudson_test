package sfs2x.client.example;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSArray;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.exceptions.SFSException;

import sfs2x.client.SmartFox;
import sfs2x.client.core.BaseEvent;
import sfs2x.client.core.IEventListener;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.SFSRoom;
import sfs2x.client.requests.ExtensionRequest;
import sfs2x.client.requests.JoinRoomRequest;
import sfs2x.client.requests.LeaveRoomRequest;
import sfs2x.client.requests.LoginRequest;

public class Client 
{
	public final SmartFox Sfs;
	final IEventListener _eventListener;
	int _num;
	String _ipaddress;
	String _name;
	String _loginID;
	String _loginName;
	
	// game play
	SFSRoom _roomJoined = null;
	
	public boolean IsReady;
	
	long sendResponseTime, receivedResponseTime;
	long avgResponseTime;
	
	public Client(int i)
    {
		InetAddress userdetails = null;
		try
		{
			userdetails = InetAddress.getLocalHost();
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		
		_name = userdetails.getHostName();
		_ipaddress = userdetails.getHostAddress();
		
		avgResponseTime = 0;

		_num = i;
		_loginID = _ipaddress +"-Test#" + _num;
		_loginName = _name + "-Test#" + _num;
		IsReady = false;
		
		System.out.println(" Initialized " + _loginID + " " + _loginName);
			
		Sfs = new SmartFox();
		Sfs.loadConfig(getCfgPath(), true);
		_eventListener = new SFSEventHandler();
		
		Sfs.addEventListener(SFSEvent.CONNECTION, _eventListener);
		Sfs.addEventListener(SFSEvent.CONNECTION_LOST, _eventListener);
		Sfs.addEventListener(SFSEvent.LOGIN, _eventListener);
		Sfs.addEventListener(SFSEvent.EXTENSION_RESPONSE, _eventListener);
		Sfs.addEventListener(SFSEvent.ROOM_JOIN, _eventListener);
		
		System.out.println(" ******** INIT COMPLETE ****************" );
    }
	
	class SFSEventHandler implements IEventListener
	{
		@Override
		public void dispatch(BaseEvent event) throws SFSException
		{
		    if(event.getType().equals(SFSEvent.CONNECTION))
		    {
		    	System.out.println("Connected! : "+ _num);
				
		    	Calendar now = Calendar.getInstance();
				sendResponseTime = now.getTimeInMillis();

		    	Sfs.send(new LoginRequest(_loginID));
		    }
		    
		    else if(event.getType().equals(SFSEvent.CONNECTION_LOST))
		    {
		    	System.out.println("Disconnected! : "+ _loginID);
		    }
		    
		    else if(event.getType().equals(SFSEvent.LOGIN))
		    {
				receivedResponseTime = Calendar.getInstance().getTimeInMillis();
				System.out.println("Log in Response Time (Millisecond) " +_num+" : "+(receivedResponseTime - sendResponseTime));
				if(avgResponseTime == 0)
				{
					avgResponseTime = receivedResponseTime - sendResponseTime;
				}
		    	
				//TestRoomExtension();

		    	JoinRoom();
		    }
		    else if(event.getType().equals(SFSEvent.ROOM_JOIN))
		    {
				receivedResponseTime = Calendar.getInstance().getTimeInMillis();
				avgResponseTime = (avgResponseTime + (receivedResponseTime - sendResponseTime))/2;
				System.out.println("Room Join " +_num+" : "+(receivedResponseTime - sendResponseTime));

		    	
		    	_roomJoined = (SFSRoom) event.getArguments().get("room");
		    	System.out.println("Room Joined! : " + _loginID + " Room " + _roomJoined.getId() + " " + _roomJoined.getName());
		    	
		    	TestRoomExtension();
		    }
		    
		    else if(event.getType().equals(SFSEvent.EXTENSION_RESPONSE))
		    {
		    	String cmd = event.getArguments().get("cmd").toString();
				ISFSObject dataObject = (SFSObject) event.getArguments().get("params");
		    	System.out.println("************Server Response********" + dataObject.getDump());

		    	if(cmd.equals("PlayerInfo"))
		    	{
	
		    	}
		    }
		}
	}
	
	public void JoinRoom()
	{
		Sfs.send(new JoinRoomRequest("Silver 5", null, null, false));
	}
	
	private void TestRoomExtension()
	{
		System.out.println("Sending game request");
		Sfs.send(new ExtensionRequest("lTest", null, _roomJoined));
		System.out.println("Game Request sent successfully");
	}

	private String getCfgPath() 
	{
		System.out.println(System.getProperty("user.dir") + "/config/sfs-config.xml");
		
		return System.getProperty("user.dir") + "/config/sfs-config.xml";
	}
}
