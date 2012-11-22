package com.mango.games.db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mango.games.db.manager.connectionpool.PoolFactory;
import com.mango.games.db.sql.UserSQL;

public class Prize 
{
	private int id;
	private String description;
	private String sponsor;
	private String img;
	private String icon;
	private String sponsor_logo;
	
	public Prize()
	{
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSponsor() {
		return sponsor;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getSponsor_logo() {
		return sponsor_logo;
	}
	public void setSponsor_logo(String sponsor_logo) {
		this.sponsor_logo = sponsor_logo;
	}
	
	@Override
	public String toString() 
	{
		String toreturn = "PRIZE: %d, %s, %s, %s, %s, %s";
		return String.format(toreturn, this.id, this.description, this.sponsor, 
				this.img, this.icon, this.sponsor_logo);
	}
	
	
	public Prize(String description, String sponsor, String img, String icon, String sponsor_logo)
	{
		
		this.description = description;
		this.sponsor = sponsor;
		this.img = img;
		this.icon = icon;
		this.sponsor_logo = sponsor_logo;
		
		
		String query = String.format(UserSQL.sqlGeneratePrize, 
		this.description, this.sponsor, this.img, this.icon, 
		this.sponsor_logo);
		System.out.println(query);
		Connection conn;
		try {
				conn = PoolFactory.getPooling().getConnection();
				String autogenColumns[] = {"id"};

				Statement stm = conn.createStatement();
				stm.executeUpdate(query , autogenColumns);
				ResultSet result_update = stm.getGeneratedKeys();

				
				
				if(result_update.first())
				{
					this.id = result_update.getInt(1);
				}
					  
			}
		catch (SQLException e) 
			{
					System.out.println("SQL Exception Code : "+e.getErrorCode());
					System.out.println("SQL Exception Message : "+e.getLocalizedMessage());
					e.printStackTrace();
			}
	}
	
	public static Prize getPrizebyID(int id) 
	{
		String query = String.format(UserSQL.sqlGetPrizeById, id);
		try {
			ResultSetHandler<Prize> h = new BeanHandler<Prize>(Prize.class);
			Connection conn = PoolFactory.getPooling().getConnection();
			QueryRunner run = new QueryRunner();
			Prize prize = run.query(conn, query, h);
			System.out.println(prize.toString());
			return prize;
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		
		return null;
	}
	
	
}
