package com.vishal.ClientApp;

import java.io.IOException;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;

public class AppInstance {
	
	public static void main(String[] args) {
		
		Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");  
        String heartbeat_timestamp = dateFormat.format(date);  
		
        App a1=new App();
        a1.setId(101);
        a1.setName("AppInst-01");
        a1.setType("LS");
        a1.setTimestamp(heartbeat_timestamp);
        
		try {
			HttpClient app = HttpClientBuilder.create().build();
			
			HttpPut putRequest = new HttpPut("http://localhost:8080/MonitorFunction/"
					+ "webresources/apps/put/" + heartbeat_timestamp + "/" + a1.getType() + "/" + a1.getId());

			putRequest.addHeader("accept", "application/json");

			HttpResponse response = app.execute(putRequest);
			
			System.out.println("============Output:============");

			System.out.println(response.getStatusLine().getStatusCode());
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
