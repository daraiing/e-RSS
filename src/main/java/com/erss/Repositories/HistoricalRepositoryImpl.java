package com.erss.Repositories;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Update;

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
	public boolean delete(Historical h) {
		try {
			BasicQuery query = new BasicQuery(
					"{$and:" + "[{ sid:'" + h.getSid() + "'}," + "{cid:'" + h.getCid() + "'}]}");
			mongoTemplate.remove(query, Historical.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Historical h) {
		try {
			BasicQuery query = new BasicQuery(
					"{$and:" + "[{ sid:'" + h.getSid() + "'}," + "{cid:'" + h.getCid() + "'}]}");
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
	public List<Historical> find(String condition) {
//		BasicQuery query = new BasicQuery("{ $or: [ { sid	:'"+ st.getSid()  	+"' },"
//				+ "	{cid:'" + h.getCid() + "'},"
//				+ " { semester : '" + st.getLname()	+ "' },"
//				+ " { year 	:  " + st.getYear()		+ "  },"
//				+ " { title : '" + st.getTitle()	+ "' },"
//				+ " { gender: '" + st.getGender()	+ "' },"
//				+ " { tid	: '" + st.getTid() 		+ "' },"
//				+ " { fcId 	: '" + st.getFcId() 	+ "' }"
//				+ "]}");
//			return mongoTemplate.find(query,Student.class);
		return null;
	}

	@Override
	public Historical findOne(String sid, String cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Historical> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
