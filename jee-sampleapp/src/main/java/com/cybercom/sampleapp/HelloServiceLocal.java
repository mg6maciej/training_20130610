package com.cybercom.sampleapp;

import javax.ejb.Local;
import javax.ws.rs.core.Response;

public interface HelloServiceLocal {

	public Response sayHello(String name);
	
}
