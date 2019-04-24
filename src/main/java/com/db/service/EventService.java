package com.db.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.db.model.Event;
import com.db.model.EventRepository;

@ApplicationScoped
public class EventService {

	@Inject
	private EventRepository eventRepository;

	@Transactional
	public void store(Event event) {
		eventRepository.save(event);
	}

	public List<Event> findAll() {
		return eventRepository.findAll();
	}

}
