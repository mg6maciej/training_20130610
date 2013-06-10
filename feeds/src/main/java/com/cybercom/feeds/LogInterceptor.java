package com.cybercom.feeds;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import com.cybercom.feeds.model.Feed;

public class LogInterceptor {

	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		System.out.println("Feed title: " + ((Feed) ctx.getParameters()[0]).getTitle());
		return ctx.proceed();
	}
}
