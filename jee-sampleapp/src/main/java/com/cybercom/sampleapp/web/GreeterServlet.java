package com.cybercom.sampleapp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybercom.sampleapp.HelloServiceLocal;

@WebServlet(urlPatterns="/web/hello")
public class GreeterServlet extends HttpServlet {

	@EJB
	HelloServiceLocal helloService;

	@Override
	protected void doGet(HttpServletRequest arg0, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		writer.append(helloService.sayHello("Jakub").getEntity().toString());
		writer.append(" " + System.currentTimeMillis());
		
	}

	
	
}
