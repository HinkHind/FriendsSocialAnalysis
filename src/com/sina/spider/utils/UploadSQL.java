package com.sina.spider.utils;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.undo.UndoableEditSupport;

import com.sina.spider.model.Weibo;
import com.sina.spider.model.WeiboUrl;



public class UploadSQL implements Upload {
	static DataBaseConnector connection = new DataBaseConnector();

	public boolean setWeibo(Weibo weibo, WeiboUrl weiboID) {
	    connection.ConnectDataBase();
		PreparedStatement pst = null;
		String INSERT_SQL = "INSERT INTO weibo_entry(weiboID, entryUrl,text,likeNumber,shareNumber,commentNumber,isShared,publishedTime) VALUES(?,?,?,?,?,?,?,?)";		
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
			pst.setDate(8, strToDate(weibo.getPublishTime()));
			
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
