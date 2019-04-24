package com.db.config;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Provider
public class JacksonContextResolver implements ContextResolver<ObjectMapper> {

	private static final ObjectMapper om = init();

	@Override
	public ObjectMapper getContext(Class<?> objectType) {
		return om;
	}

	private static ObjectMapper init() {
		ObjectMapper om = new ObjectMapper();
		om.registerModule(new JavaTimeModule());
		om.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		return om;
	}
}
