package com.cybercom.feeds;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

@Stateless
public class FeedEventObserver {

	@Asynchronous
	public void log(@Observes FeedEvent event) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(event.getLog());
		System.out.println(System.currentTimeMillis());
	}
	
}
