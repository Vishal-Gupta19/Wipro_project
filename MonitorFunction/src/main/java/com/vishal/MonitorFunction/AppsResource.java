package com.vishal.MonitorFunction;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("apps")
public class AppsResource {
	AppRepository repo = new AppRepository();
	
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
	
	@POST
	@Path("post")
	@Consumes(MediaType.APPLICATION_JSON)
	public App createApp(App a1) {
		
		System.out.println(a1);
		repo.create(a1);
		return a1;
	}
}