package it.testWebapp.mysql2.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.testWebapp.model.CustomObject;
import it.testWebapp.mysql2.dao.CustomObjectDao;

@Transactional
@Repository
public class CustomObjectDaoImpl implements CustomObjectDao {
	
	@PersistenceContext(unitName="testDbPU")
	private EntityManager entityManager;

	@Override
	public void createCustomObject(CustomObject customObject) {
		entityManager.persist(customObject);
	}

	@Override
	public CustomObject getCustomObject(Integer id) {
		return entityManager.find(CustomObject.class, id);
	}

	@Override
	public List<CustomObject> geCustomObjectsByName(String name) {
		Query q = entityManager.createNamedQuery("FROM CustomObject WHERE name = ?", CustomObject.class);
		q.setParameter(1, name);
		return q.getResultList();
	}

	@Override
	public List<CustomObject> getCustomObject() {
		return entityManager.createQuery("FROM CustomObject ORDER BY id", CustomObject.class).getResultList();
	}

}
