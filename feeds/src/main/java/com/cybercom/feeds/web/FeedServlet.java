package com.cybercom.feeds.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybercom.feeds.FeedBuilder;
import com.cybercom.feeds.model.Feed;
import com.sun.syndication.feed.synd.SyndFeed;

@WebServlet(urlPatterns = "/web/feeds")
public class FeedServlet extends HttpServlet {

	@EJB
	FeedBuilder parser;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String rss = req.getParameter("rss");

		Feed parse = parser.fromXml(rss);

		PrintWriter writer = resp.getWriter();
		writer.append("Feed with " + parse.getItems().size() + " item(s)");
	}

}
