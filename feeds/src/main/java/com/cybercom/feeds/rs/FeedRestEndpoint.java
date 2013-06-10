package com.cybercom.feeds.rs;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cybercom.feeds.FeedRepository;
import com.cybercom.feeds.model.Feed;

@Path("/rs")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
public class FeedRestEndpoint {

	@Inject
	FeedRepository repository;
	
	@Path("/feeds")
	@GET
	public Feed[] getFeeds() {
		return repository.getFeeds().toArray(new Feed[] {});
	}
	
}
