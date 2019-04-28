package com.db.rest;

import java.time.LocalDateTime;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.db.model.Event;
import com.db.model.EventRepository;
import com.db.service.EventService;

@ApplicationScoped
@Path("/events")
public class EventRest {

	@Inject
	private EventService eventService;
	@Inject
	private EventRepository eventRepository;

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
		System.out.println("-----------------------------------");
		System.out.println("getEvents: " + LocalDateTime.now());
		List<Event> allEvents = eventService.findAll();
		System.out.println(allEvents);
		return allEvents;
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Event getEventById(@PathParam("id") int id) {
		System.out.println("-----------------------------------");
		System.out.println("getEventById: " + LocalDateTime.now());
		Event event = eventRepository.findById(id);
		System.out.println(event);
		return event;
	}

}
