package com.cybercom.feeds;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import com.cybercom.feeds.model.Feed;

public class LogInterceptor {
	
	@Inject
	Event<FeedEvent> events;
	
	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		System.out.println(System.currentTimeMillis());
		
		events.fire(new FeedEvent("Feed title: " + ((Feed) ctx.getParameters()[0]).getTitle()));
		return ctx.proceed();
	}
}
