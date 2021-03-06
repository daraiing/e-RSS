package com.erss.Repositories;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Update;

import com.erss.Models.Student;

public class StudentRepositoryImpl implements StudentRepository {

	MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Student findOne(String sid) {
		BasicQuery query = new BasicQuery("{ sid:'" + sid + "'}");
		return mongoTemplate.findOne(query, Student.class);
	}

	@Override
	public List<Student> find(Student st) {
		try {
			String bson = "{ $and:[";
			bson = bson
					+ (st.getSid() == null || st.getSid().isEmpty() ? ""
							: (bson.charAt(bson.length() - 1) == '[' ? "" : ",") + "{ sid: '" + st.getSid() + "'} ")
					+ (st.getFname() == null || st.getFname().isEmpty() ? ""
							: (bson.charAt(bson.length() - 1) == '[' ? "" : ",") + "{ fname: '" + st.getFname() + "'} ")
					+ (st.getLname() == null || st.getLname().isEmpty() ? ""
							: (bson.charAt(bson.length() - 1) == '[' ? "" : ",") + "{ lname: '" + st.getLname() + "'} ")
					+ (st.getTitle() == null || st.getTitle().isEmpty() ? ""
							: (bson.charAt(bson.length() - 1) == '[' ? "" : ",") + "{ title: '" + st.getTitle() + "'} ")
					+ (st.getYear() == 0 ? ""
							: (bson.charAt(bson.length() - 1) == '[' ? "" : ",") + "{ year: " + st.getYear() + "} ")
					+ (st.getTid() == null || st.getTid().isEmpty() ? ""
							: (bson.charAt(bson.length() - 1) == '[' ? "" : ",") + "{ tid: '" + st.getTid() + "'} ")
					+ (st.getFcid() == null || st.getFcid().isEmpty() ? ""
							: (bson.charAt(bson.length() - 1) == '[' ? "" : ",") + "{ fcid: '" + st.getFcid() + "'} ")
					+ (st.getGender() == null || st.getGender().isEmpty() ? ""
							: (bson.charAt(bson.length() - 1) == '[' ? "" : ",") + "{ gender: '" + st.getGender() + "'} ")
					+ " ] }";
			System.err.println(bson);
			BasicQuery query = new BasicQuery(bson);
			return mongoTemplate.find(query, Student.class);
		} catch (Exception ex) {
			return mongoTemplate.findAll(Student.class);
		}
	}

	@Override
	public List<Student> findByAdvisor(String tid) {
		BasicQuery query = new BasicQuery("{ tid:'" + tid + "'}");
		return mongoTemplate.find(query, Student.class);
	}

	@Override
	public boolean insert(Student st) {
		try {
			mongoTemplate.save(st);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(Student st) {
		try {
			BasicQuery query = new BasicQuery("{ sid:'" + st.getSid() + "'}");
			mongoTemplate.remove(query, Student.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Student st) {
		try {
			BasicQuery query = new BasicQuery("{ sid:'" + st.getSid() + "'}");
			Update update = new Update();
			update.set("fname", st.getFname());
			update.set("lname", st.getLname());
			update.set("year", st.getYear());
			update.set("password", st.getPassword());
			update.set("tid", st.getTid());
			update.set("fcid", st.getFcid());
			mongoTemplate.updateFirst(query, update, Student.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
