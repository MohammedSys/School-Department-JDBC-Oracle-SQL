package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbTransaction {
	private String url;
	private String tableName;
	private String tableName1;
	private String tableName2;
	private Connection connection;
	private String user;
	private String password;
	
	DbTransaction(){
		
	}
	
	DbTransaction(String url, String tableName, String tableName1, String user, String password){
		this.url = url;
		this.tableName = tableName;
		this.tableName1 = tableName1;
		this.user = user;
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableName1() {
		return tableName1;
	}

	public void setTableName1(String tableName1) {
		this.tableName1 = tableName1;
	}

	public String getTableName2() {
		return tableName2;
	}

	public void setTableName2(String tableName2) {
		this.tableName2 = tableName2;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Connection getConnection()
	{
		try {
			closeConnection();
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			connection = DriverManager.getConnection(
//			          "jdbc:oracle:thin:@localhost:1521:" + "xe", "system",
//			          "system");
			connection = DriverManager.getConnection(this.url, this.user, this.password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void closeConnection()
	{
		try
		{
			if(connection != null && connection.isClosed() == false)
			connection.close();
			connection = null;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}