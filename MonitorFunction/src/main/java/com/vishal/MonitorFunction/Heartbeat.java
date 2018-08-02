package com.vishal.MonitorFunction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Heartbeat extends TimerTask {

	public String Date() {
	Date date = Calendar.getInstance().getTime();  
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");  
    String heartbeat_timestamp = dateFormat.format(date); 
    return heartbeat_timestamp;
	}
	int i=1;
	@Override
    public void run() {
		
        System.out.println(i+" attempt started at: "+Date());
        completeTask();
        System.out.println(i-1+" attempt finished at:"+Date());
        System.out.println();
    }
	
	//AppsResource start = new AppsResource();
	
	//Sleep for 30 seconds
    public void completeTask() {	
        try {
            Thread.sleep(5000);		//Initially running for 5sec for testing
            i++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
    	
        TimerTask timerTask = new Heartbeat();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 4*1000);
        System.out.println("Heartbeat Sensing started");
        
        //Stop after 3 attempts
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        
        System.out.println("Heartbeat Sensing stopped");
        System.out.println("Probe message sent");

    }

}
