package com.cybercom.sampleapp;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/rs/")
@Stateless
@Local(HelloServiceLocal.class)
public class HelloService implements HelloServiceLocal, HelloServiceRemote, Serializable {

	@PostConstruct
	public void setup() {
		System.out.println("Hello World is created.");
	}
	
	@Path("/hello/{name}")
	@GET
	public Response sayHello(@PathParam("name") String name) {
		return Response.ok().entity("Hello! " + name).build();
	}
	
}
