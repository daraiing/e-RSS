package com.erss.Repositories;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Update;

import com.erss.Models.Course;
import com.erss.Models.Student;

public class CourseRepositoryImpl implements CourseRepository {

	MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public boolean insert(Course c) {
		try {
			mongoTemplate.save(c);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(Course c) {
		try {
			BasicQuery query = new BasicQuery("{ cid:'" + c.getCid() + "'}");
			mongoTemplate.remove(query, Course.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Course c) {
		try {
			BasicQuery query = new BasicQuery("{ cid:'" + c.getCid() + "'}");
			Update update = new Update();
			update.set("cname",c.getCname());
			update.set("ccredit",c.getCcredit());
			update.set("tid",c.getTid());
			update.set("cdescription",c.getCdescription());
			mongoTemplate.updateFirst(query, update, Course.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Course> find(Course c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findOne(String cid) {
		BasicQuery query = new BasicQuery("{ cid:'" + cid+ "'}");
		return mongoTemplate.findOne(query, Course.class);
	}

}
