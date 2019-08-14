package com.emp.service;

import java.util.List;

public interface CommonService<Model,Query> {
	
	
	public List<Model> findAll();
	public List<Model> findByQuery(Query query);
	
	public Model save(Model model);
	
	public Model update(Model model);
	
	

}
