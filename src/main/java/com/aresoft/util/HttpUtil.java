package com.aresoft.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpUtil {
	private static String cookie = "dumaScrollAreaId_98CookieName=1358; dumaScrollAreaId_31CookieName=0; icbcUserAnalysisId=2017041839601248; filtervertion=D3F6C6AF-4D7E-403e-8D5A-9CCFC452F040; ismobile=false";

	public static String post(String path, Map<String, String> map) {
		//System.out.println(System.getProperty("http.proxyHost"));
		BufferedReader br = null;
		OutputStream os = null;
		HttpURLConnection conn = null;
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL(path);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Cookie", cookie);
			conn.setRequestProperty("Host", "www.icbc.com.cn");
			conn.setRequestProperty("Origin", "http://www.icbc.com.cn");
			conn.setRequestProperty("Referer", "http://www.icbc.com.cn/ICBCDynamicSite2/LBS/nets/netsappointreal.aspx");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
			conn.setRequestProperty("X-MicrosoftAjax", "Delta=true");
			
			
			StringBuffer buffer = new StringBuffer();
			if (map != null && !map.isEmpty()) {
				for (Map.Entry<String, String> entry : map.entrySet())
					buffer.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
				buffer.deleteCharAt(buffer.length() - 1);
			}
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			conn.getOutputStream().write(buffer.toString().getBytes("UTF-8"));

			//conn.getOutputStream().write(test.getBytes("UTF-8"));
			//System.out.println(URLEncoder.encode(buffer.toString()));
			//System.out.println(test);
			if (conn.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
				String lines;
				while ((lines = br.readLine()) != null)
					sb.append(lines);
				Map<String, List<String>> head = conn.getHeaderFields();
				Set<String> set = head.keySet();
				for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
					String key = iterator.next();
					if (key != null && "Set-Cookie".equals(key)) {
						List<String> list = head.get(key);
						StringBuilder builder = new StringBuilder();
						for (String str : list)
							builder.append(str).toString();
						cookie = builder.toString();
					}
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.disconnect();
				if (br != null)
					br.close();
				if (os != null)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return sb.toString();
	}
	
	
}