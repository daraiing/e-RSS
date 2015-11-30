package com.erss.Repositories;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.erss.Models.Historical;

public class HistoricalRepositoryImpl implements HistoricalRepository {


	MongoTemplate mongoTemplate;
	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Historical findOne(int sid, int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Historical findBySid(String sid, String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Historical h) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String sid, String cid) {
		// TODO Auto-generated method stub
		return false;
	}

}
