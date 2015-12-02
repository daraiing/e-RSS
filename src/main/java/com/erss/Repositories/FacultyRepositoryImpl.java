package com.erss.Repositories;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Update;

import com.erss.Models.Faculty;

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
			BasicQuery query = new BasicQuery("{ fcid:'" + f.getFcid() + "'}");
			mongoTemplate.remove(query, Faculty.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Faculty f) {
		try {
			BasicQuery query = new BasicQuery("{ fcid:'" + f.getFcid() + "'}");
			Update update = new Update();
			update.set("fcname", f.getFcname());
			mongoTemplate.updateFirst(query, update, Faculty.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Faculty> find(Faculty fc) {
		try {
			String bson = "{ $and:[";
			bson = bson
					+ (fc.getFcname() == null || fc.getFcname().isEmpty() ? ""
							: (bson.charAt(bson.length() - 1) == '[' ? "" : ",") + "{ fcname: '" + fc.getFcname() + "'} ")
					+ (fc.getFcid() == null || fc.getFcid().isEmpty() ? ""
							: (bson.charAt(bson.length() - 1) == '[' ? "" : ",") + "{ fcid: '" + fc.getFcid() + "'} ")
					+ " ] }";
			System.err.println(bson);
			BasicQuery query = new BasicQuery(bson);
			return mongoTemplate.find(query, Faculty.class);
		} catch (Exception ex) {
			return mongoTemplate.findAll(Faculty.class);
		}
	}

	@Override
	public Faculty findOne(String fcid) {
		BasicQuery query = new BasicQuery("{ fcid:'" + fcid + "'}");
		return mongoTemplate.findOne(query, Faculty.class);
	}

}
