package com.cybercom.feeds;

import java.util.List;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cybercom.feeds.model.Feed;
import com.cybercom.feeds.model.Item;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class FeedRepository {

//	private ArrayList<Feed> feeds = new ArrayList<Feed>();
	
	@PersistenceContext
	EntityManager em;
	
	@Interceptors(LogInterceptor.class)
	public void add(Feed feed) {
		em.persist(feed);
//		feeds.add(feed);
	}

	public List<Feed> getFeeds() {
//		return new ArrayList<Feed>(feeds);
		throw new IllegalStateException("Not implemented");
	}

}
