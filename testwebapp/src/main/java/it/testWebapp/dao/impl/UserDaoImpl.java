package it.testWebapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.testWebapp.dao.UserDao;
import it.testWebapp.model.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public void createUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public User getUser(Integer id) {
		return entityManager.find(User.class, id);
	}
	
	@Override
	public List<User> getUserByName(String name) {
		Query q = entityManager.createNamedQuery("FROM User WHERE name = ?", User.class);
		q.setParameter(1, name);
		return q.getResultList();
	}
	
	@Override
	public User getUserByEmail(String email) {
		Query q = entityManager.createNamedQuery("FROM User WHERE email = ?", User.class);
		q.setParameter(1, email);
		return (User) q.getSingleResult();
	}

	@Override
	public List<User> getUsers() {
		return entityManager.createQuery("FROM User ORDER BY id", User.class).getResultList();
	}
}
