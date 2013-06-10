package com.cybercom.feeds;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

import org.junit.Test;

import com.cybercom.feeds.model.Feed;
import com.sun.syndication.feed.synd.SyndFeed;

public class FeedParserTest {

	@Test
	public void test() throws Exception {
		URL dir_url = FeedParserTest.class.getResource("/");
		File dir = new File(dir_url.toURI());
		File xml = new File(dir, "example.xml");

		String xmlBody = new Scanner(xml).useDelimiter("\\A").next();
		
		FeedBuilder parser = new FeedBuilder();
		Feed feed = parser.fromXml(xmlBody);
		
		assertThat(feed.getItems().size(), equalTo(1));
	}
	
}
