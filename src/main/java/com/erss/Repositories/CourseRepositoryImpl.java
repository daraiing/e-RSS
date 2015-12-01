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
			update.set("cname", c.getCname());
			update.set("ccredit", c.getCcredit());
			update.set("cdescription", c.getCdescription());
			update.set("tid", c.getTid());
			mongoTemplate.updateFirst(query, update, Course.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Course> find(Course c) {
		BasicQuery query = new BasicQuery("{ $or: [ { cid	:'"+ c.getCid() +"' },"
				+ "	{ cname	: '" + c.getCname() 	+ "' },"
				+ " { ccredit : '" + c.getCcredit()	+ "' },"
				+ " { cdescription 	:  " + c.getCdescription()+ "  },"
				+ " { tid	: '" + c.getTid() 		+ "' }"
				+ "]}");
			return mongoTemplate.find(query,Course.class);
	}

	@Override
	public Course findOne(String cid) {
		BasicQuery query = new BasicQuery("{ cid:'" + cid + "'}");
		return mongoTemplate.findOne(query, Course.class);
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
