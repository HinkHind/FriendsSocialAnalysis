package com.zhihu.spider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {
	
	public static void StringBufferDemo(String str) throws IOException{
        File file=new File("E:\\Spider\\zhihu.txt");
        if(!file.exists())
            file.createNewFile();
        FileOutputStream out=new FileOutputStream(file,true);        
        StringBuffer sb=new StringBuffer();
        sb.append(str);
        out.write(sb.toString().getBytes("utf-8"));       
        out.close();
    }

	public static String getDate(String str) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
//		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		str  = str.substring(4);
		if(str.startsWith("20"));
		else if (str.startsWith("昨天")) {
			str = df.format(getPrtDay(new Date())) + str.substring(3);
		}else{
			str = df.format(new Date()) + str;
		}
		str = str.replace("-", "");
		str = str.replace(":", "");
		return str;
		
	}
	
	public static Date getPrtDay(Date date) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.add(Calendar.DAY_OF_MONTH, -1);  
        date = calendar.getTime();  
        return date;  
    }  
	

}
