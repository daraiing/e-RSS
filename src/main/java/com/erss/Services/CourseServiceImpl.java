package com.erss.Services;

import org.springframework.beans.factory.annotation.Autowired;

import com.erss.Models.Course;
import com.erss.Models.Message;
import com.erss.Repositories.CourseRepository;
import com.erss.Util.Crypto;

public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepository courseRepository;

	@Override
	public Message findOne(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message find(Course c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message insert(Course c) {

		if (courseRepository.findOne(c.getCid()) != null) {
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("This CourseId Already Exist in the Database");
			return msg;
		}
		if (c.getCid() == null || c.getCname() == null) {
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("This CourseId or Course Name are required field!");
			return msg;
		}
		if (courseRepository.insert(c)) {
			Message msg = new Message(Message.MSG_SUCCESS);
			msg.setMsgContent("Course Insert Successfully");
			return msg;
		} else {
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("Insert Failed");
			return msg;
		}
	}

	@Override
	public Message delete(Course c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message update(Course c) {
		// TODO Auto-generated method stub
		return null;
	}

}
