package com.erss.Repositories;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.erss.Models.Historical;

public class HistoricalRepositoryImpl implements HistoricalRepository {


	MongoTemplate mongoTemplate;
	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public boolean insert(Historical h) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(Historical h) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Historical h) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Historical> find(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Historical findOne(String sid, String cid) {
		// TODO Auto-generated method stub
		return null;
	}

}
