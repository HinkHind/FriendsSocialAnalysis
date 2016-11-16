package com.sina.spider.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sina.spider.model.Weibo;
import com.sina.spider.model.WeiboUrl;


public class DownloadSQL implements Download {
	static DataBaseConnector connection = new DataBaseConnector();
	

	public WeiboUrl getOneNewWbUrl() {
		 connection.ConnectDataBase();
		 PreparedStatement pst = null;
		 ResultSet rs = null;
			String SEARCH_SQL = "SELECT  weiboUrl,weiboID,tag"
			 		+ " FROM weibo_url"
			 		+ " WHERE isNew = 1 ORDER BY weiboID LIMIT 1";
		try {
			WeiboUrl wb = new WeiboUrl();
			pst = connection.connect.prepareStatement(SEARCH_SQL);
			rs = pst.executeQuery();
			while (rs.next()) {
				wb.setWeiboUrl(rs.getString("weiboUrl"));
				wb.setWeiboID(rs.getInt("weiboID"));
			}
			rs.close();
			pst.close();
			connection.Close();
			return wb;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	 
	@Override
	public ArrayList<WeiboUrl> getNewWeiboUrl() {
		ArrayList<WeiboUrl> wbList = new ArrayList<WeiboUrl>();
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
				WeiboUrl wb = new WeiboUrl();
				wb.setWeiboID(rs.getInt("weiboID"));
				wb.setWeiboUrl(rs.getString("weiboUrl"));
				wb.setTag(rs.getInt("tag"));
			   
				wbList.add(wb);				
			}
			rs.close();
			pst.close();
			connection.Close();
			return wbList;
		  } catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}


	/**
	 * 根据是否分析的标签获取为更新分析的微博text,第一轮暂时以originLikeNumber作为tag
	 * @param WeiboID
	 * @return
	 */
	public ArrayList<Weibo> getWeiboText() {
		ArrayList<Weibo> wbList = new ArrayList<Weibo>();
		connection.ConnectDataBase();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String SEARCH_SQL = "SELECT entryID,text"
		 		+ " FROM weibo_entry"
		 		+ " WHERE originLikeNumber = ?";
		try {
			pst = connection.connect.prepareStatement(SEARCH_SQL);
			pst.setInt(1, 0);
			rs = pst.executeQuery();
			while (rs.next()) {
				Weibo wb = new Weibo();
				wb.setEntryID(rs.getInt("entryID"));
				wb.setText(rs.getString("text"));
				wbList.add(wb);				
			}
			rs.close();
			pst.close();
			connection.Close();
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
