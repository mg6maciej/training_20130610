package com.cybercom.feeds;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.interceptor.Interceptors;

import com.cybercom.feeds.model.Feed;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class FeedRepository {

	private ArrayList<Feed> feeds = new ArrayList<Feed>();
	
	@Interceptors(LogInterceptor.class)
	public void add(Feed feed) {
		feeds.add(feed);
	}

	public List<Feed> getFeeds() {
		return new ArrayList<Feed>(feeds);
	}

}
