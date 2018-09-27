package it.testWebapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.testWebapp.dao.UserDao;
import it.testWebapp.model.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<User> getUsers() {

		return userDao.getUsers();
	}

	public User getUser(int id) {

		return userDao.getUser(id);
	}

}
