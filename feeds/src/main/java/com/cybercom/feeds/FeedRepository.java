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

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class FeedRepository {

	@PersistenceContext
	EntityManager em;
	
	@Interceptors(LogInterceptor.class)
	public void add(Feed feed) {
		em.persist(feed);
	}

	public List<Feed> getFeeds() {
		return em.createNamedQuery(Feed.FIND_ALL, Feed.class).getResultList();
	}

}
