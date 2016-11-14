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
	
	
	
    public static void tmain(String[] args) throws IOException {
        if (args.length < 1 || !(args[0].equals("xml") 
                                || args[0].equals("json") 
                                || args[0].equals("conll"))) {
            System.out.println("Usage: java SimpleAPI [xml/json/conll]");
            return;
        }

        String api_key = "YourApiKey";
        String pattern = "all";
        String format  = args[0];
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


