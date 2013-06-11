package com.cybercom.feeds;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Default;
import javax.interceptor.Interceptors;

import com.cybercom.feeds.model.Feed;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Default
public class InMemoryFeedRepository implements FeedRepository {

	private ArrayList<Feed> repo = new ArrayList<Feed>();

	@Override
	@Interceptors(LogInterceptor.class)
	public void add(Feed feed) {
		repo.add(feed);
	}

	@Override
	public List<Feed> getFeeds() {
		return new ArrayList<Feed>(repo);
	}

}
