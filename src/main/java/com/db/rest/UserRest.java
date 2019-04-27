package com.db.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.db.model.User;
import com.db.model.UserRepository;

@Path("/user")
@ApplicationScoped
public class UserRest {

	@Inject
	private UserRepository userRepository;

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public User getUserById(@PathParam("id") int id) {
		User user = userRepository.findById(id);
		System.out.println(user);
		return user;
	}
}
