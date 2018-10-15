package it.testWebapp.mysql.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.testWebapp.model.User;
import it.testWebapp.mysql.dao.UserDao;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext(unitName="mysqlPU")
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
