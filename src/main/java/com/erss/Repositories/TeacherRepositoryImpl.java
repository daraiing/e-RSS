package com.erss.Repositories;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.erss.Models.Teacher;

public class TeacherRepositoryImpl implements TeacherRepository {

	MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Teacher fineOne(String tid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Teacher t) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(Teacher t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Teacher t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Teacher> find(Teacher t) {
		// TODO Auto-generated method stub
		return null;
	}

}
