package com.cybercom.feeds;

import java.util.List;

import javax.interceptor.Interceptors;

import com.cybercom.feeds.model.Feed;

public interface FeedRepository {

	public abstract void add(Feed feed);
	public abstract List<Feed> getFeeds();

}