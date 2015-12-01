package com.erss.Repositories;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Update;

import com.erss.Models.Teacher;

public class TeacherRepositoryImpl implements TeacherRepository {

	MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Teacher fineOne(String tid) {
		BasicQuery query = new BasicQuery("{ tid:'" + tid + "'}");
		return mongoTemplate.findOne(query, Teacher.class);
	}

	@Override
	public boolean insert(Teacher t) {
		try {
			mongoTemplate.save(t);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	@Override
	public boolean delete(Teacher t) {
		try {
			BasicQuery query = new BasicQuery("{ tid:'" + t.getTid() + "'}");
			mongoTemplate.remove(query, Teacher.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Teacher t) {
		try {
			BasicQuery query = new BasicQuery("{ tid:'" + t.getTid() + "'}");
			Update update = new Update();
			update.set("fname",t.getFname());
			update.set("lname",t.getLname());
			update.set("field",t.getField());
			update.set("password",t.getPassword());
			update.set("title", t.getTitle());
			mongoTemplate.updateFirst(query, update, Teacher.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Teacher> find(Teacher t) {
		BasicQuery query = new BasicQuery("{ $or: [ { tid	:'"+ t.getTid()  	+"' },"
				+ "	{ fname	: '" + t.getFname() + "' },"
				+ " { lname : '" + t.getLname()	+ "' },"
				+ " { gender: '" + t.getGender()+ "'  },"
				+ " { title : '" + t.getTitle()	+ "' },"
				+ " { field : '" + t.getField()	+ "' }"
				+ "]}");
			return mongoTemplate.find(query,Teacher.class);
	}

	@Override
	public List<Teacher> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
