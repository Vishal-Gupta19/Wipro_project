package com.vishal.MonitorFunction;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class ProbeMsg {
	
	public void  get(String url) throws ClientProtocolException, IOException {
		
		App a=new App();
		url="http://localhost:8080/MonitorFunction/webresources/probe/"+a.getType();
				
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse closablehttpresponse = httpClient.execute(httpget);
		int statusCode = closablehttpresponse.getStatusLine().getStatusCode();
		
		System.out.println("Status Code: "+ statusCode);
		
		boolean AvailabilityStatus;
		
		if(statusCode==200) {
			AvailabilityStatus=true;
		}
		else {
			AvailabilityStatus=false;
		}
	}

}
