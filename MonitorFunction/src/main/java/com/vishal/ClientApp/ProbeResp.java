package com.vishal.ClientApp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("probe/{type}")
public class ProbeResp {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String response(@PathParam("type") String type) {
		
		System.out.println("App with type= "+type+" is available.");
		
		return "Status= Available" ;
	}

}
