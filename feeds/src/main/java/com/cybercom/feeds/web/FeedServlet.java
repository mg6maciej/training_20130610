package com.cybercom.feeds.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybercom.feeds.FeedBuilder;
import com.cybercom.feeds.FeedRepository;
import com.cybercom.feeds.model.Feed;

@WebServlet(urlPatterns = "/web/feeds")
public class FeedServlet extends HttpServlet {

	@Inject
	FeedBuilder parser;
	
	@Inject
	FeedRepository repository;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String rss = req.getParameter("rss");
		Feed feed = parser.fromXml(rss);

		repository.add(feed);
		
		PrintWriter writer = resp.getWriter();
		writer.append("Feed with " + feed.getItems().size() + " item(s)");
	}

}
