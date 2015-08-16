package com.dw.planisto.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/welcome")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WelcomeResource {
	
	public WelcomeResource(){
	}
	
	@GET
	@Path("/{userName}")
	public String getWelComeMessage(@PathParam("userName") String userName){
		return "welcome " + userName;
	}
}
