package com.sina.spider.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnector {
	//static String url = "jdbc:mysql://ymhscshkvhif.rds.sae.sina.com.cn:10623/bookdb?characterEncoding=utf-8";
	static String url = "jdbc:mysql://localhost:3306/db?characterEncoding=utf-8";
	static String user = "root";
	static String password = "123456789";
	
	public Connection connect;
	public Statement sta;
	public PreparedStatement pst;

	public void ConnectDataBase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
