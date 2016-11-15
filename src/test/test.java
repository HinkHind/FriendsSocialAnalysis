package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.geccocrawler.gecco.spider.render.RequestFieldRender;
import com.sina.spider.model.WeiboUrl;
import com.sina.spider.utils.DownloadSQL;

public class test {
	
	
	
    public static void main(String[] args) throws IOException {
  

        String api_key = "V8Y6h4B8jaFcFIMy5hfqxKuxaHsoPAvYXq6Eguou";
        String pattern = "ws";
        String format  = "json";
        String text    = "我爱北京天安门。";
        text = URLEncoder.encode(text, "utf-8");

        URL url     = new URL("http://ltpapi.voicecloud.cn/analysis/?"
                              + "api_key=" + api_key + "&"
                              + "text="    + text    + "&"
                              + "format="  + format  + "&"
                              + "pattern=" + pattern);
        URLConnection conn = url.openConnection();
        conn.connect();

        BufferedReader innet = new BufferedReader(new InputStreamReader(
                                conn.getInputStream(),
                                "utf-8"));
        String line;
        while ((line = innet.readLine())!= null) {
            System.out.println(line);
        }
        innet.close();
    }
}


