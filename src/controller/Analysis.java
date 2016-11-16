package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import hibernateMapping.Friend;
import hibernateMapping.WeiboEntry;
import hibernateUtil.HibernateUtil;

public class Analysis extends ActionSupport{

	private List<Integer> activityDegree;
	private List<HabitRatio> habitRatios;
	private String test;
	
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public List<Integer> getActivityDegree() {
		return activityDegree;
	}

	public void setActivityDegree(List<Integer> activityDegree) {
		this.activityDegree = activityDegree;
	}

	public List<HabitRatio> getHabitRatios() {
		return habitRatios;
	}

	public void setHabitRatios(List<HabitRatio> habitRatios) {
		this.habitRatios = habitRatios;
	}


	public String displayAnalysis() {
		
		
		ActionContext context = ActionContext.getContext();
		
		
		
		
		int friendId = (int)context.getSession().get("friendId");
		//String selectedPlat = (String)context.get("selectedPlatform");
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		Friend friend = (Friend) session.get(Friend.class, friendId);
		
		//TODO: 目前基于微博分析
		
		
		if (friend.isHasWeibo()) {
			Set analysisEntries = friend.getWeiboUrl().getWeiboEntries();
			activityDegree = new ArrayList<>();
			for (int i = 0; i < 24; i++) {
				activityDegree.add(0);
			}
			WeiboEntry weiboEntry = null;
			for (Object object : analysisEntries) {
				weiboEntry = (WeiboEntry) object;

				//Time analyze;
				@SuppressWarnings("deprecation")
				int hour = weiboEntry.getPublishedTime().getHours();
				activityDegree.set(hour, activityDegree.get(hour).intValue() + 1);

			} 
		}
		
		
		
//		switch (selectedPlat) {
//		case "weibo":
//			analysisEntries = friend.getWeiboUrl().getWeiboEntries();
//			break;
//		case "zhihu":
//			analysisEntries = friend.getZhihuUrl().getZhihuEntries();
//			break;
//		case "csdn":
//			
//		default:
//			break;
//		}
		
				
		transaction.commit();
		HibernateUtil.closeSession();
		
//		for (int i = 0; i < activityDegree.size(); i++) {
//			activityDegree.set(i, new Integer(i * 3));
//		}
		setTest("Test Java Pro");
		return SUCCESS;
	}
}

class HabitRatio{
	private String habit;
	private Double ratio;
	
	public String getHabit() {
		return habit;
	}
	public void setHabit(String habit) {
		this.habit = habit;
	}
	public Double getRatio() {
		return ratio;
	}
	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}
	
	
}