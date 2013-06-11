package com.cybercom.feeds;

import java.util.List;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Alternative;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cybercom.feeds.model.Feed;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Alternative
public class DatabaseFeedRepository implements FeedRepository {

	@PersistenceContext
	EntityManager em;

	@Override
	@Interceptors(LogInterceptor.class)
	public void add(Feed feed) {
		em.persist(feed);
	}

	@Override
	public List<Feed> getFeeds() {
		return em.createNamedQuery(Feed.FIND_ALL, Feed.class).getResultList();
	}

}
