package com.emp.mapper;

import java.util.List;

public interface IbatisMapper<Model,Query> {
	
	List<Model> findByQuery(Query query);
	List<Model> findAll();
	Integer findNextSeq();
    void save(Model model);
    void update(Model model);

}
