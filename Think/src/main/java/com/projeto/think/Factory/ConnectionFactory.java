package com.projeto.think.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;

public class ConnectionFactory
{
	@Value("#{configProperties['database.code']}")
	private static String code;
	
	@Value("#{configProperties['database.host']}")
	private static String host;
	
	@Value("#{configProperties['database.name']}")
	private static String database;
	
	@Value("#{configProperties['database.user']}")
	private static String user;
	
	@Value("#{configProperties['database.password']}")
	private static String password;
	
	@Value("#{configProperties['database.driver']}")
	private static String driver;
	
	static
	{
		try
		{
			//Class.forName(driver);
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println( e.getMessage() );
		}
	}
	
	public static Connection getConnection() throws SQLException
	{
		//return DriverManager.getConnection(
				//"jdbc:" + code + "://" + host + "/" + database + "?user=" + user + "&password=" + password );
		return DriverManager
				.getConnection("jdbc:mysql://localhost:3306/TCC?user=root&password=12345");
	}
	
	public static void printURL()
	{
		System.out.println(
				"jdbc:" + code + "://" + host + "/" + database + "?user=" + user + "&password=" + password );
	}
	
	public static void closeConnection( Connection conn ) throws SQLException
	{
		conn.close();
	}
}
