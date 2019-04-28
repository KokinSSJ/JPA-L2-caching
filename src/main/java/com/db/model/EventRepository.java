package com.db.model;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EventRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Event> findAll() {
		return entityManager.createNamedQuery(Event.Query.FIND_ALL, Event.class).getResultList();
	}

	public void save(Event event) {
		entityManager.persist(event);
	}

	public Event findById(int id) {
		return entityManager.find(Event.class, id);
	}
}
