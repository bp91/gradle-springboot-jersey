package it.testWebapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.collect.ImmutableMap;
import it.testWebapp.model.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private List<Map<String, Object>> users;
	
	@Autowired
	public UserService() {

		Map<String, Object> u1 = new HashMap<String, Object>();
		Map<String, Object> u2 = new HashMap<String, Object>();
		Map<String, Object> u3 = new HashMap<String, Object>();
		Map<String, Object> u4 = new HashMap<String, Object>();

		u1.put("id", 1);
		u1.put("name", "bruno");
		u1.put("surname", "pistone");
		u2.put("id", 2);
		u2.put("name", "aaa");
		u2.put("surname", "aaa");
		u3.put("id", 3);
		u3.put("name", "aaa");
		u3.put("surname", "aaa");
		u4.put("id", 4);
		u4.put("name", "aaa");
		u4.put("surname", "aaa");

		this.users = new ArrayList<Map<String, Object>>();

		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
	}

	 public List<Map<String, Object>> getUsers() {
	
	 return sqlSessionTemplate.selectList("testWebapp-users");
	 }
	
	 public Map<String, Object> getUser(int id) {
	
	 return sqlSessionTemplate.selectOne("testWebapp-users", ImmutableMap.of("id",
	 id));
	 }
	
}
