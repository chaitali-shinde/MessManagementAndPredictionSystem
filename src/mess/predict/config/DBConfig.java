package mess.predict.config;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DBConfig {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static  ResultSet rs;
	
//	public static void main(String x[]) {
//		new DBConfig();
//	}

	private static DBConfig db = null;
	
	public DBConfig() {
		try {
			
			Properties p = new Properties();
			p.load(PathHelper.fin);
			//System.out.println(PathHelper.f.getAbsolutePath());
			String driverClassName = p.getProperty("driver.classname");
			String username = p.getProperty("db.username");
			String password = p.getProperty("db.password");
			String  url = p.getProperty("db.url");
	
			Class.forName(driverClassName); //this data get from properties file
			
			conn = DriverManager.getConnection(url,username,password);
			
			if(conn!=null) {
				System.out.println("Database is connected...");
			}
			else {
				System.out.println("Database is not connected...");
			}
		}
		catch(Exception ex) {
			System.out.println("Error is " + ex);
		}
	}
	
	
	public static DBConfig getDBInstance() {//singleton
		if(db == null) {
			db = new DBConfig();
		}
		return db;
	}
	
	public static Connection getConnection() {
		return conn;
		
	}
	
	public static PreparedStatement getStatement() {
		return pstmt;
	}
	
	public static  ResultSet getResultSet() {
		return rs;
	}
}
