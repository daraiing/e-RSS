package com.erss.Repositories;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.erss.Models.Student;

public class StudentRepositoryImpl implements StudentRepository {

	MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Student findOne(String sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Student st) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Student st) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Student st) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Student> find(Student st) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByAdvisor(String tid) {
		// TODO Auto-generated method stub
		return null;
	}

}
