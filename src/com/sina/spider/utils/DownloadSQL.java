package com.sina.spider.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sina.spider.model.weiboUrl;


public class DownloadSQL implements Download {
	static DataBaseConnector connection = new DataBaseConnector();
	

	@Override
	public ArrayList<weiboUrl> getNewWeiboUrl() {
		ArrayList<weiboUrl> wbList = new ArrayList<weiboUrl>();
		connection.ConnectDataBase();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String SEARCH_SQL = "SELECT weiboUrl,weiboID,tag"
		 		+ " FROM weibo_url"
		 		+ " WHERE isNew = 1";
		try {
			pst = connection.connect.prepareStatement(SEARCH_SQL);
			rs = pst.executeQuery();
			while (rs.next()) {
				weiboUrl wb = new weiboUrl();
				wb.setWeiboID(rs.getInt("weiboID"));
				wb.setWeiboUrl(rs.getString("weiboUrl"));
				wb.setTag(rs.getInt("tag"));
			   
				wbList.add(wb);				
			}
			pst.close();
			return wbList;
		  } catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}


	@Override
	public ArrayList<String> getNewZhihuUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getNewCSDNUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWeiboNumByUser(String userID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getZhihuNUmByUser(String userID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCSDNNUmByUser(String userID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
