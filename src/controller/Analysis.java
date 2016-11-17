package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import utils.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

import hibernateMapping.Friend;
import hibernateMapping.WeiboEntry;
import hibernateUtil.HibernateUtil;

public class Analysis extends ActionSupport{
	
	private List<Integer> activityDegree;
	private Map<String, Integer> habitCounts = new TreeMap<>();
	private List<HabitCount> habitRatios;
	private String test;
	private String[] colorList = {"#fedd74",
									"#a5c2d5",
									"#cbab4f",
									"#76a871",
									"#fd9fc1",
									"#a56f8f",
									"#c12c44",
									"#6f83a5",
									"#80bd91",
									"#f76864"
									};


	public String[] getColorList() {
		return colorList;
	}

	public void setColorList(String[] colorList) {
		this.colorList = colorList;
	}

	public Map<String, Integer> getHabitCounts() {
		return habitCounts;
	}

	public void setHabitCounts(Map<String, Integer> habitCounts) {
		this.habitCounts = habitCounts;
	}

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

	public List<HabitCount> getHabitRatios() {
		return habitRatios;
	}

	public void setHabitRatios(List<HabitCount> habitRatios) {
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
			
			
			//init habitCounts Map
			for (String dictName : Constants.getDictFileSet()) {
				habitCounts.put(dictName, new Integer(0));
			}
			
			for (Object object : analysisEntries) {
				weiboEntry = (WeiboEntry) object;

				//Time analyze;
				@SuppressWarnings("deprecation")
				int hour = weiboEntry.getPublishedTime().getHours();
				activityDegree.set(hour, activityDegree.get(hour).intValue() + 1);
				
				//TODO: bad code >_<;
				//habit Analyze;
				for (String dictName : Constants.getDictFileSet()) {
					switch (dictName) {
					case "art":
						habitCounts.put(dictName, 
								new Integer(habitCounts.get(dictName).intValue() + weiboEntry.getArt()));
						break;
					case "cultural":
						habitCounts.put(dictName, 
								new Integer(habitCounts.get(dictName).intValue() + weiboEntry.getCultural()));
						break;
					case "engineering":
						habitCounts.put(dictName, 
								new Integer(habitCounts.get(dictName).intValue() + weiboEntry.getEngineering()));
						break;
					case "entertainment":
						habitCounts.put(dictName, 
								new Integer(habitCounts.get(dictName).intValue() + weiboEntry.getEntertainment()));
						break;
					case "game":
						habitCounts.put(dictName, 
								new Integer(habitCounts.get(dictName).intValue() + weiboEntry.getGame()));
						break;
					case "living":
						habitCounts.put(dictName, 
								new Integer(habitCounts.get(dictName).intValue() + weiboEntry.getLiving()));
						break;
					case "medicine":
						habitCounts.put(dictName, 
								new Integer(habitCounts.get(dictName).intValue() + weiboEntry.getMedicine()));
						break;
					case "science":
						habitCounts.put(dictName, 
								new Integer(habitCounts.get(dictName).intValue() + weiboEntry.getScience()));
						break;
					case "social":
						habitCounts.put(dictName, 
								new Integer(habitCounts.get(dictName).intValue() + weiboEntry.getSocial()));
						break;
					case "sports":
						habitCounts.put(dictName, 
								new Integer(habitCounts.get(dictName).intValue() + weiboEntry.getSports()));
						break;
						
					default:
						break;
					}
				}
				


			} 
			
			
			
			
		}
		
		
		

		
				
		transaction.commit();
		HibernateUtil.closeSession();
		//habitCounts.put("art", new Integer(1));
		//habitCounts.put("cultural", new Integer(2));
//		for (int i = 0; i < activityDegree.size(); i++) {
//			activityDegree.set(i, new Integer(i * 3));
//		}
		
		
		setTest("Test Java Pro");
		return SUCCESS;
	}
}

class HabitCount{
	private String habit;
	private int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getHabit() {
		return habit;
	}
	public void setHabit(String habit) {
		this.habit = habit;
	}
	
	
}