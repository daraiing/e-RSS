package com.erss.Repositories;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.erss.Models.Faculty;

public class FacultyRepositoryImpl implements FacultyRepository{

	MongoTemplate mongoTemplate;
	
	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Faculty findOne(int fcId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Faculty> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Faculty f) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Faculty fcId) {
		// TODO Auto-generated method stub
		return false;
	}

}
