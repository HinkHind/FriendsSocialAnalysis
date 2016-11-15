package com.sina.spider;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import com.sina.spider.utils.Constants;

public class HabitAnalyzer {
	
	private Map<String, Set<String>> totalDict = new HashMap<>();
	
	public  HabitAnalyzer() {
		this.init();
	}
	
	public Map<String, Set<String>> getTotalDict() {
		return totalDict;
	}

	public void setTotalDict(Map<String, Set<String>> totalDict) {
		this.totalDict = totalDict;
	}

	public void init() {
		InputStream in;
		String[] dictFileSet = Constants.getDictFileSet();
		
		
		for (String dictFileName : dictFileSet) {
			Set<String> tmpDict = loadDict(dictFileName);
			//TODO: here is not good;
			//getDict().put(dictFileName.substring(0, dictFileName.length() - 4), loadDict(dictFileName));
			getTotalDict().put(dictFileName, tmpDict);
		}
		
		
	}
	
	public Set<String> loadDict(String fileName) {
		InputStream inputStream;
		
		Set<String> Dict = new HashSet<String>();
		try {
			inputStream = new FileInputStream("src/" + fileName);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				Dict.add(line);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Dict;
	}
	
	public Map<String, Integer> analyzeEntry(List<String> entryWordList) {
		Map<String, Integer> classCount = new HashMap<>();
		
		for(String key : getTotalDict().keySet())
		{
			classCount.put(key, new Integer(0));
		}
		
		
		for (String word : entryWordList) {
			//考虑了一个词可能再多个词库种出现的情况，所以遍历了整个词库
			for (Map.Entry<String, Set<String>> entry : getTotalDict().entrySet()) {
				if (entry.getValue().contains(word)) {
					//entry.getKey()是类别的名字，比如science
					classCount.put(entry.getKey(), 
							new Integer(classCount.get(entry.getKey()).intValue() + 1));
				}
			}
		}
		return classCount;
	}
	
	public static void main(String args[]){
		HabitAnalyzer habitAnalyzer = new HabitAnalyzer();
		
		//habitAnalyzer.init();
		List<String> eList = new LinkedList<>();
		eList.add("药品");
		eList.add("牛顿法");
		eList.add("马克思");
		Map<String, Integer> map = habitAnalyzer.analyzeEntry(eList);
		System.out.println(map);
	}
	
}
