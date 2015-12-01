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
	public Message findOne(String cid) {
		if(courseRepository.findOne(cid) == null)
		{
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("This CourseId is not exist in the database");
			return msg;
		}
		if(courseRepository.findOne(cid) != null)
		{
			Message msg = new Message(Message.MSG_SUCCESS);
			msg.setMsgContent(courseRepository.findOne(cid));
			return msg;
		}
		else
		{
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("Cannot find");
			return msg;
		}
	}

	@Override
	public Message find(Course c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message insert(Course c) {
		// String credit = "" + c.getCcredit();
		String credit = "" + c.getCcredit();
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
		if (c.getCid() == "") {
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("Please input the correct courseid you would like to delete!");
			return msg;
		}

		if (courseRepository.findOne(c.getCid()) == null) {
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("The course that you want to delete is not exist in the database");
			return msg;
		}

		if (courseRepository.delete(c)) {
			Message msg = new Message(Message.MSG_SUCCESS);
			msg.setMsgContent("The course is already deleted from database");
			return msg;
		} else {
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("Delete Failed");
			return msg;
		}
	}

	@Override
	public Message update(Course c) {
		// int credit = Integer.parseInt(c.getCcredit());
		Course c1 = courseRepository.findOne(c.getCid());
		if (c.getCid() == "" || c.getCid() == null) {

			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("Please input the correct courseid you would like to update!");
			return msg;
		}

		if (c1 == null) {
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("The course that you want to update is not exist in the database");
			return msg;
		}
		if (c1 != null) {
			if (c.getCname() == null || c.getCname()=="") {
				c.setCname(c1.getCname());
			}
			if(c.getCdescription() == null || c.getCdescription()=="")
			{
				c.setCdescription(c1.getCdescription());
			}
			if(c.getCcredit() == -1)
				
			{
				c.setCcredit(c1.getCcredit());
			}
		}
		if (courseRepository.update(c)) {
			Message msg = new Message(Message.MSG_SUCCESS);
			msg.setMsgContent("The course is already updated");
			return msg;

		} else {
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("Update Failed");
			return msg;
		}
	}

}
