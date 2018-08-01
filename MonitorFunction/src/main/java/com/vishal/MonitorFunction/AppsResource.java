package com.vishal.MonitorFunction;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("apps")
public class AppsResource {
	AppRepository repo = new AppRepository();
	Heartbeat delay=new Heartbeat();
	
	public void main(String[] args) {
		
		delay.completeTask();
		System.out.println("Reading incoming request...");
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<App> getApps(){
		System.out.println("Get all the apps");
		return repo.getApps();
	}
	
	@GET
	@Path("get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public App getApp(@PathParam("id") int id) {
		System.out.println("Get app with id:" + id);
		return repo.getApp(id);
	}
	
	@PUT
	@Path("put/{timestamp}/{type}/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public App updateApp(
			@PathParam("timestamp")String timestamp,
			@PathParam("type")String type,
			@PathParam("id")int id) {
		App a1=new App();;
		a1.setId(id);
		a1.setTimestamp(timestamp);
		a1.setType(type);
		System.out.println(a1);
		if(repo.getApp(a1.getId()).getId()==0) {
			repo.create(a1);
		}
		repo.update(a1);
		return a1;
	}
	
//	@POST
//	@Path("post")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public App createApp(App a1) {
//		
//		System.out.println(a1);
//		repo.create(a1);
//		return a1;
//	}
}