package com.cybercom.sampleapp;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/rs/")
@Stateless
public class HelloService {

	@Path("/hello/{name}")
	@GET
	public Response sayHello(@PathParam("name") String name) {
		return Response.ok().entity("Hello! " + name).build();
	}
	
}
