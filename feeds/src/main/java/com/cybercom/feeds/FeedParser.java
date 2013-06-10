package com.cybercom.feeds;

import java.io.StringReader;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;

public class FeedParser {

	public SyndFeed parse(String xml) throws Exception {
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new StringReader(xml));
		
		return feed;
	}
	
}
