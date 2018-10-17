package it.testWebapp.mysql2.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.testWebapp.model.CustomObject;
import it.testWebapp.mysql2.dao.CustomObjectDao;

@Transactional
@Repository
public class CustomObjectDaoImpl implements CustomObjectDao {
	
	@PersistenceContext(unitName="testDbPU")
	private EntityManager entityManager;
	
	private SessionFactory getSessionFactory() {
		if(entityManager.unwrap(Session.class).getSessionFactory() == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		return entityManager.unwrap(Session.class).getSessionFactory();
	}

	protected Session currentSession() {
		return this.getSessionFactory().getCurrentSession();
	}

	@Override
	public void createCustomObject(CustomObject customObject) {
		this.currentSession().persist(customObject);
	}

	@Override
	public CustomObject getCustomObject(Integer id) {
		return this.currentSession().find(CustomObject.class, id);
	}

	@Override
	public List<CustomObject> geCustomObjectsByName(String name) {
		this.currentSession().beginTransaction();
		Query q = this.currentSession().createNamedQuery("FROM CustomObject WHERE name = ?", CustomObject.class);
		q.setParameter(1, name);
		return q.getResultList();
	}

	@Override
	public List<CustomObject> getCustomObjects() {
		this.currentSession().beginTransaction();
		return this.currentSession().createQuery("FROM CustomObject ORDER BY id", CustomObject.class).getResultList();
	}

}
