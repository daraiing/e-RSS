package com.erss.Repositories;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Update;

import com.erss.Models.Course;
import com.erss.Models.Faculty;
import com.erss.Models.Historical;
import com.erss.Models.Student;

public class HistoricalRepositoryImpl implements HistoricalRepository {

	MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public boolean insert(Historical h) {
		try {
			mongoTemplate.save(h);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	@Override
	public boolean delete(String sid, String cid) {
		try {
			String bson = "{ $and: [";
			bson = bson + (sid==null||sid.isEmpty() ? "" : (bson.charAt(bson.length()-1)=='['?"":",")
					+ " { sid : '" + sid + "'}");
			bson = bson + (cid==null||cid.isEmpty() ? "" : (bson.charAt(bson.length()-1)=='['?"":",")
					+ " { cid : '" + cid + "'}");
			bson = bson + "]}";
			BasicQuery query = new BasicQuery(bson);
			mongoTemplate.remove(query, Historical.class);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Historical h) {
		try {
			String bson = "{ $and: [";
			bson = bson + (h.getSid()==null||h.getSid().isEmpty() ? "" : (bson.charAt(bson.length()-1)=='['?"":",")
					+ " { sid : '" + h.getSid() + "'}");
			bson = bson + (h.getCid()==null||h.getCid().isEmpty() ? "" : (bson.charAt(bson.length()-1)=='['?"":",")
					+ " { cid : '" + h.getCid() + "'}");
			bson = bson + "]}";
			BasicQuery query = new BasicQuery(bson);
			Update update = new Update();
			update.set("semester", h.getSemester());
			update.set("grade", h.getGrade());
			mongoTemplate.updateFirst(query, update, Historical.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Historical> find(Historical h) {
		try {
			String bson = "{ $and:[";
			bson = bson
					+ (h.getSid() == null || h.getSid().isEmpty() ? ""
							: (bson.charAt(bson.length() - 1) == '[' ? "" : ",") + "{ sid: '" + h.getSid() + "'} ")
					+ (h.getCid() == null || h.getCid().isEmpty() ? ""
							: (bson.charAt(bson.length() - 1) == '[' ? "" : ",") + "{ cid: '" + h.getCid() + "'} ")
					+ (h.getSemester() == null || h.getSemester().isEmpty() ? ""
							: (bson.charAt(bson.length() - 1) == '[' ? "" : ",") + "{ semester: '" + h.getSemester() + "'} ")
					+ (h.getGrade() == -1 || h.getGrade() == 0.0? ""
							: (bson.charAt(bson.length() - 1) == '[' ? "" : ",") + "{ grade: '" + h.getGrade() + "'} ")
					+ " ] }";
			System.err.println(bson);
			BasicQuery query = new BasicQuery(bson);
			return mongoTemplate.find(query, Historical.class);
		} catch (Exception ex) {
			return mongoTemplate.findAll(Historical.class);
		}
	}

	@Override
	public Historical findOne(String sid, String cid) {
		String bson = "{ $and: [";
		bson = bson + (sid==null||sid.isEmpty() ? "" : (bson.charAt(bson.length()-1)=='['?"":",")
				+ " { sid : '" + sid + "'}");
		bson = bson + (cid==null||cid.isEmpty() ? "" : (bson.charAt(bson.length()-1)=='['?"":",")
				+ " { cid : '" + cid + "'}");
		bson = bson + "]}";
		BasicQuery query = new BasicQuery(bson);
		return mongoTemplate.findOne(query, Historical.class);
	}

}
