package com.db.rest;

import java.time.LocalDateTime;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.db.model.Event;
import com.db.service.EventService;

@ApplicationScoped
@Path("/events")
public class EventRest {

	@Inject
	EventService eventService;

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addEvent(Event event) {
//	    	event.setId(new Random().nextInt(1_000_000_000));
		eventService.store(event);
		return "{\"result\":\"" + LocalDateTime.now() + "\"}";
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Event> getEvents() {
		System.out.println(LocalDateTime.now());
		System.out.println(eventService.findAll());
		return eventService.findAll();
	}

	@GET
	@Path("/count")
	@Produces(MediaType.APPLICATION_JSON)
	public int getStatistics() {
		System.out.println(LocalDateTime.now());
		return eventService.findAll().size();
	}

}
