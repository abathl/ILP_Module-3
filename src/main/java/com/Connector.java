package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	public static Connector instance;
	private Connection connection;
	//connection string to Fatima's DB
	private String url = "jdbc:oracle:thin:@10.101.1.151:1521:XE";
	private String uname = "system";
	private String pwd = "tcs12345";


	//private constructor
	private Connector() throws SQLException{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (ClassNotFoundException e) {
			//DB connection failed ... do something to signify
			System.out.println("hit CNF1");
			e.printStackTrace();
		}
	}


	public Connection getConnection() {
		try {
			if(connection.isClosed()) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				this.connection = DriverManager.getConnection(url, uname, pwd);
			}
		}catch(ClassNotFoundException e) {
			//DB connection failed...
			System.out.println("hit CNF2");
		}
		catch(SQLException e) {
			//DB connection failed...
			System.out.println("hit SQL");
		}
		return connection;
	}


	public static Connector getInstance() throws SQLException{
		//if singleton is null or closed, reconnect. Either way, return instance
		if(instance == null) {
			instance = new Connector();
		}
		else if(instance.getConnection().isClosed()) {
			instance = new Connector();
		}
		return instance;

	}

	public void closeConnection() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			//nothing to log
		}
	}
}
