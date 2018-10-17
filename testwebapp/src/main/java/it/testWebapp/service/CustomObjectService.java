package it.testWebapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.testWebapp.model.CustomObject;
import it.testWebapp.mysql2.dao.CustomObjectDao;

@Service
@Transactional
public class CustomObjectService {
	
	@Autowired
	private CustomObjectDao customObjectDao;
	
	public CustomObject getCustomObject(Integer id) {
		return customObjectDao.getCustomObject(id);
	}
	
	public List<CustomObject> getCustomObjects() {
		return customObjectDao.getCustomObjects();
	}
}
