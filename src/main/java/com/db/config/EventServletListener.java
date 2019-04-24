package com.db.config;

import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.db.model.Event;
import com.db.service.EventService;

@WebListener
public class EventServletListener implements ServletContextListener {

	@Inject
	private EventService eventService;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("------------ Initializing ----------");
		for (int i = 0; i < 1_000; i++) {
			Event event = new Event();
			event.setTime(LocalDateTime.now());
			event.setMessage("message " + LocalDateTime.now());
			eventService.store(event);
		}

		System.out.println("--------------- End of inititializing ----------");

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
