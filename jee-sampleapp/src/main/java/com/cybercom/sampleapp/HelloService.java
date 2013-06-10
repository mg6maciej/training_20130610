package com.cybercom.sampleapp;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/rs/")
@Stateless
public class HelloService {

	@Path("/hello/{name}")
	@GET
	public String sayHello(@PathParam("name") String name) {
		return "Hello! " + name;
	}
	
}
