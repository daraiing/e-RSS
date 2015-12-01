package com.erss.Repositories;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Update;

import com.erss.Models.Faculty;
import com.erss.Models.Student;

public class FacultyRepositoryImpl implements FacultyRepository {

	MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public boolean insert(Faculty f) {
		try {
			mongoTemplate.save(f);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(Faculty f) {
		try {
			BasicQuery query = new BasicQuery("{ fcId:'" + f.getFcid() + "'}");
			mongoTemplate.remove(query, Faculty.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Faculty f) {
		try {
			BasicQuery query = new BasicQuery("{ fcId:'" + f.getFcid() + "'}");
			Update update = new Update();
			update.set("fcName",f.getFcname());
			mongoTemplate.updateFirst(query, update, Faculty.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Faculty> find(Faculty fc) {
		BasicQuery query = new BasicQuery(
						"{ $or: [ { fcId	:'" + fc.getFcid() + "' }," + 
						"{ fcName	:'" + fc.getFcname() + "' }" + "]}");
		return mongoTemplate.find(query, Faculty.class);
	}

	@Override
	public Faculty findOne(String fcId) {
		BasicQuery query = new BasicQuery("{ fcId:'" + fcId + "'}");
		return mongoTemplate.findOne(query, Faculty.class);
	}

}
