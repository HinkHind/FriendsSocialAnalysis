package com.sina.spider.utils;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBConn {	
	public static String CONN_URL = "jdbc:mysql://localhost:3306/sina_weibo?characterEncoding=utf-8";
	public static String USERNAME = "root";
	public static String PASSWORD = "123456";
	
	private DBConn() {
		
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(CONN_URL, USERNAME, PASSWORD);
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}
}
