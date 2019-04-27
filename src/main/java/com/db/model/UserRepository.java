package com.db.model;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<User> findAll() {
		return entityManager.createNamedQuery(User.Query.FIND_ALL, User.class).getResultList();
	}

	public User findById(int id) {
		return entityManager.find(User.class, id);
	}
}
