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
	public Teacher findOne(String tid) {
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
			update.set("fname", t.getFname());
			update.set("lname", t.getLname());
			update.set("field", t.getField());
			update.set("password", t.getPassword());
			update.set("title", t.getTitle());
			mongoTemplate.updateFirst(query, update, Teacher.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Teacher> find(Teacher t) {
		try {
			String bson = "{ $and: [";
			bson = bson + (t.getTid()==null||t.getTid().isEmpty() ? "" : (bson.charAt(bson.length()-1)=='['?"":",")
					+ " { tid : '" + t.getTid() + "'}");
			bson = bson + (t.getFname()==null||t.getFname().isEmpty() ? "" : (bson.charAt(bson.length()-1)=='['?"":",")
					+ " { fname : '" + t.getFname() + "'}");
			bson = bson + (t.getLname()==null||t.getLname().isEmpty() ? "" : (bson.charAt(bson.length()-1)=='['?"":",") 
					+ " { lname : '" + t.getLname() + "'}");
			bson = bson + (t.getGender()==null||t.getGender().isEmpty() ? "" : (bson.charAt(bson.length()-1)=='['?"":",")
					+ " { gender: '" + t.getGender() + "'}");
			bson = bson + (t.getTitle()==null||t.getTitle().isEmpty() ? "" : (bson.charAt(bson.length()-1)=='['?"":",")
					+ " { title : '" + t.getTitle() + "'}");
			bson = bson + (t.getField()==null||t.getField().isEmpty() ? "" : (bson.charAt(bson.length()-1)=='['?"":",")
					+ " { field : '" + t.getField() + "'}");
			bson = bson + "]}";
			System.err.println(bson);
			BasicQuery query = new BasicQuery(bson);
			return mongoTemplate.find(query, Teacher.class);
		} catch (Exception ex) {
			return mongoTemplate.findAll(Teacher.class);
		}

	}

}
