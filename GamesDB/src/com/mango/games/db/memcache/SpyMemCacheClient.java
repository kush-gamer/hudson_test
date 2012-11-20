package com.mango.games.db.memcache;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

import java.util.Locale;
import java.util.ResourceBundle;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.BinaryConnectionFactory;
import net.spy.memcached.ConnectionObserver;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.OperationTimeoutException;

public class SpyMemCacheClient 
{
	
	private MemcachedClient cacheClient = null;
	private int numberofserver;
	private String[] ipAddress;
	private int[] portNumber;
	private int expiryTime;
	private boolean isConnected = false;
	private ConnectionObserver observer;

	private static SpyMemCacheClient _mInstance = null;
	
	private SpyMemCacheClient()
	{
		CreateCacheClient();
	}
	
	
	public static SpyMemCacheClient getInstance()
	{
		if( _mInstance == null )
			 _mInstance = new SpyMemCacheClient();
		
		return _mInstance;
	}
	
	public boolean IsConnected()
	{
		return isConnected;
	}
	public Object get(String key)
	{
		if(cacheClient!= null)
		{
			try
			{
				System.out.println("Cache Get Method (IsConnected) : "+isConnected);
				if(isConnected)
					cacheClient.get(key);
				else
					System.out.println("In get Server Disconnected");
			}
			catch(OperationTimeoutException e)
			{
				System.out.println("Get Time OUt ");
			}
		}
		return null;
	}
	
	public void delete(String key)
	{
		
		if(cacheClient!= null)
		{
			try
			{
				cacheClient.delete(key);
			}
			catch(OperationTimeoutException e)
			{
				System.out.println("ERROR : Could Not Able to connect to Cache Server");
				
			}
		}
	}
	
	public void add(String key , Object obj)
	{
		if(cacheClient!=null)
		{
			try
			{
				System.out.println("Cache Add Method (IsConnected) : "+isConnected);
				if(isConnected)
					cacheClient.add(key , 3600 , obj);
				else
					System.out.println("In add Server Disconnected");
			}
			catch(OperationTimeoutException e)
			{
				System.out.println("ERROR : Timed OUT");
			}
		}
	}
	
	/*public MemcachedClient getInstance()
	{
		if(cacheClient == null)
		{
			CreatecacheClient();
		}
		return cacheClient;
	}*/
	
	
	private void CreateObserver()
	{
		observer = new ConnectionObserver() {
			
			public void connectionLost(SocketAddress arg0) {
				// TODO Auto-generated method stub
				isConnected = false;
				System.out.println("Observer : Connection Lost !!!");
			}
			
			public void connectionEstablished(SocketAddress arg0, int arg1) {
				// TODO Auto-generated method stub
				isConnected = true;
				System.out.println("Observer :  Connection Established !!!");
			}
		};
	}
	private void CreateCacheClient()
	{
		ReadProperties();
		CreateObserver();
		if(numberofserver > 1)
		{
			// For Multiple Cache Server
			try {
					cacheClient = new MemcachedClient(new BinaryConnectionFactory() , AddrUtil.getAddresses(getConnectionString()));
					System.out.println("Using Multiple Cache Server");
				}
			catch (IOException e) {
			System.out.println("MemCache Exception : "+e.getCause());
			System.out.println("Memcache Message : "+e.getLocalizedMessage());
			e.printStackTrace();
			}
			cacheClient.addObserver(observer);
		}
		
		else if(numberofserver == 1)
		{
			// For one Cache Server
			try
			{
				
				cacheClient = new MemcachedClient(new InetSocketAddress(ipAddress[0] , portNumber[0]));
				System.out.println("Using Single Cache Server");
				
				//cacheClient.shutdown(5, TimeUnit.SECONDS);
				
			}
			catch(OperationTimeoutException e)
			{
				System.out.println("Timed Out ");
				cacheClient = null;
			}
			catch (IOException e) {
			System.out.println("MemCache Exception : "+e.getCause());
			System.out.println("Memcache Message : "+e.getLocalizedMessage());
			e.printStackTrace();
			}
			
			cacheClient.addObserver(observer);
		}
		else
			System.out.println("ERROR : Number of Server Value is Not Specified in the Properties File");
	}
	
	
	private String getConnectionString()
	{
		String conn = null;
		if(numberofserver > 0)
		{
			int i = 0;
			for(i=0 ; i<numberofserver-1 ;i++)
			{
				conn = ipAddress[i];
				conn.concat(":"+portNumber[i]);
				conn.concat(" ");
			}
			conn = ipAddress[i];
			conn = conn.concat(":"+portNumber[i]);
			System.out.println("IP : "+ipAddress[i]);
			System.out.println("Port : "+portNumber[i]);
		}
		System.out.println("Connection String : "+conn);
		return conn;
	}
	private void ReadProperties()
	{
		Locale l = new Locale("en", "IN");
        Locale.setDefault(l);
		ResourceBundle bundle = ResourceBundle.getBundle("com.mango.games.db.memcache.server",
				Locale.getDefault());
		System.out.println(bundle.getLocale().toString());
		
		String server = bundle.getString("NumberOfServer");
		numberofserver = Integer.parseInt(server);
		expiryTime = Integer.parseInt(bundle.getString("ExpiryTime"));
		
		ipAddress = new String[numberofserver];
		portNumber = new int[numberofserver];
		
		for(int i=1;i<=Integer.parseInt(server);i++)
		{
			ipAddress[i-1] = bundle.getString("server"+i+"-IP");
			portNumber[i-1] = Integer.parseInt(bundle.getString("server"+i+"-Port"));
			
		}
		
	}

	/**
	 * @return the expiryTime
	 */
	public int getExpiryTime() {
		return this.expiryTime;
	}

	/**
	 * @param expiryTime the expiryTime to set
	 */
	public void setExpiryTime(int expiryTime) {
		this.expiryTime = expiryTime;
	}
	
	public static void main(String args[])
	{
		SpyMemCacheClient ins = SpyMemCacheClient.getInstance();
		while(ins.IsConnected())
		{
			System.out.println("heyy 1");
			ins.add("byee", "hooo");
			//ins.get("byee");
			ins.add("byee", "hooo");
		}
		
		
		
			System.out.println("Not Connected");
		
		/*try
		{
			ins.add("hello", "kushagra");
		}
		catch(OperationTimeoutException e)
		{
			System.out.println("timed ouuttttttt : "+e.getLocalizedMessage());
		}
		try
		{
			System.out.println("Object : "+ins.get("hello"));
		}
		catch(OperationTimeoutException e)
		{
			System.out.println("get time out :"+e.getLocalizedMessage());
		}*/
	}

}
