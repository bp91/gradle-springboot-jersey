package it.testWebapp.mysql2.dao;

import java.util.List;

import it.testWebapp.model.CustomObject;

public interface CustomObjectDao {
	
	public void createCustomObject(CustomObject user);
	
	public CustomObject getCustomObject(Integer id);
	
	public List<CustomObject> geCustomObjectsByName(String name);
	
	public List<CustomObject> getCustomObjects();
}
