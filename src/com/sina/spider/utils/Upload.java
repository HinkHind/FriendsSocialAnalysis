package com.sina.spider.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sina.spider.model.Weibo;



public class Upload {
	static DataBaseConnector connection = new DataBaseConnector();

	public boolean setWeibo(Weibo weibo) {
	    connection.ConnectDataBase();
		PreparedStatement pst = null;
		String INSERT_SQL = "INSERT INTO zhihu_entry(zhihuID,contentHolder,publishedTime,hasRead,classHolder) VALUES(?,?,?,?,?)";		
		boolean flag = false;
        try {
			pst = connection.connect.prepareStatement(INSERT_SQL);
			pst.setLong(1, 2);
			pst.setString(2, weibo.getPublishTime());
			pst.setString(3, "1999-9-9");
			pst.setLong(4,0);
			pst.setString(5, weibo.getId());
			int i = pst.executeUpdate();
			if (i == 1) {
				flag = true;
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
