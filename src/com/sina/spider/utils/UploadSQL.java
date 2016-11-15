package com.sina.spider.utils;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.swing.undo.UndoableEditSupport;

import com.sina.spider.model.Weibo;
import com.sina.spider.model.WeiboUrl;



public class UploadSQL implements Upload {
	static DataBaseConnector connection = new DataBaseConnector();
	 
	 public static String Strformat(String str) {
		 	String temp = str.substring(0, 4) + "-" + str.substring(4,6)+"-"+str.substring(6,8)+ " "+
			str.substring(8,10)+":"+str.substring(10,12)+":"+str.substring(12);
		 	return temp;
	 }
	public boolean setWeibo(Weibo weibo, WeiboUrl weiboID) {
	    connection.ConnectDataBase();
		PreparedStatement pst = null;
		String INSERT_SQL = "INSERT INTO weibo_entry(weiboID, entryUrl,text,likeNumber,shareNumber,commentNumber,isShared,publishedTime, originLikeNumber) VALUES(?,?,?,?,?,?,?,?,?)";		
		boolean flag = false;
        try {
			pst = connection.connect.prepareStatement(INSERT_SQL);
			pst.setLong(1, weiboID.getWeiboID());
			pst.setString(2, weibo.getEntryUrl());
			pst.setString(3, weibo.getText());
			pst.setLong(4,weibo.getLikeNum());
			pst.setLong(5, weibo.getShareNum());
			pst.setLong(6, weibo.getCommentNum());
			pst.setInt(7,  weibo.getIsShared());
			pst.setString(8, weibo.getPublishTime());
			pst.setInt(9, 0);

			
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


	public boolean updateWeiboNew(int weiboID) {
		
		 connection.ConnectDataBase();
			PreparedStatement pst = null;
			String INSERT_SQL = "UPDATE weibo_url SET isNew = 0 WHERE weiboID = ?";		
			boolean flag = false;
	        try {
				pst = connection.connect.prepareStatement(INSERT_SQL);
				pst.setLong(1, weiboID);
				
				
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
	
	
	public boolean updateWeiboNum(Weibo weibo) {
		 connection.ConnectDataBase();
			PreparedStatement pst = null;
			String INSERT_SQL = "UPDATE weibo_entry SET art=?,cultural=?,engineering=?,entertainment=?,game=?,living=?,medicine=?,science=?,social=?,sports=? WHERE entryID = ?";		
			boolean flag = false;
	        try {
				pst = connection.connect.prepareStatement(INSERT_SQL);
				pst.setInt(1, weibo.getArt());
				pst.setInt(2, weibo.getCultural());
				pst.setInt(3, weibo.getEngineering());
				pst.setInt(4, weibo.getEntertainment());
				pst.setInt(5, weibo.getGame());
				pst.setInt(6, weibo.getLiving());
				pst.setInt(7, weibo.getMedicine());
				pst.setInt(8, weibo.getScience());
				pst.setInt(9, weibo.getSocial());
				pst.setInt(10, weibo.getSports());
				pst.setInt(11, weibo.getEntryID());
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
	
	@Override
	public boolean updateTag(String url) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateWeiNum() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateZhihuNum() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCSDNNum() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertWeibo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertZhihu() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertCSDN() {
		// TODO Auto-generated method stub
		return false;
	}
}
