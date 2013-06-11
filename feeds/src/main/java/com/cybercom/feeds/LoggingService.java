package com.cybercom.feeds;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

import com.cybercom.feeds.model.Feed;

@Stateless
public class LoggingService {

	@Asynchronous
	public void log(String item) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(item);
		System.out.println(System.currentTimeMillis());
	}
	
}
