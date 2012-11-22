package sfs2x.client.example;

import java.util.Random;

public class BasicClientExample
{
	public int MaxUsers;
	public Client[] ListClients;
	
	public boolean AllclientsConnected;
	
	BasicClientExample()
	{
		MaxUsers = 1;
		AllclientsConnected = false;
	}
	
	public static void main(String[] args)
	{
		BasicClientExample obj = new BasicClientExample();
		obj.ListClients = new Client[obj.MaxUsers];
		
		for(int i = 0; i<obj.MaxUsers; i++)
		{
			obj.ListClients[i] = new Client(i);
		}
		
		/*do
		{
			obj.AllclientsConnected = true;
			
			for(int i=0; i<obj.MaxUsers; i++)
			{
				if(obj.ListClients[i].Sfs.isConnected() == false)
				{
					System.out.println("All Clients are NOT Connected : " + i);
					obj.AllclientsConnected = false;
				}
			}
			
		}while(obj.AllclientsConnected == false);
		
		if(obj.AllclientsConnected)
		{
			obj.StartTesting();
		}*/
	}
	
	public void StartTesting()
	{
		System.out.println("testing Starts");
	}
}
