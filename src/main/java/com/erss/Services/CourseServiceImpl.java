package com.erss.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.erss.Models.Course;
import com.erss.Models.Message;
import com.erss.Repositories.CourseRepository;
import com.erss.Util.Crypto;

public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepository courseRepository;

	@Override
	public Course findOne(String cid) {
		if(courseRepository.findOne(cid) == null)
		{
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("This CourseId is not exist in the database");
			return null;
		}
		if(courseRepository.findOne(cid) != null)
		{
			Message msg = new Message(Message.MSG_SUCCESS);
			msg.setMsgContent(courseRepository.findOne(cid));
			return null;
		}
		else
		{
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("Cannot find");
			return null;
		}
	}

	@Override
	public List<Course> find(Course c) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Message insert(Course c) {
//		// String credit = "" + c.getCcredit();
//		String credit = "" + c.getCcredit();
//		if (courseRepository.findOne(c.getCid()) != null) {
//			Message msg = new Message(Message.MSG_ERROR);
//			msg.setMsgContent("This CourseId Already Exist in the Database");
//			return msg;
//		}
//		if (c.getCid() == null || c.getCname() == null) {
//			Message msg = new Message(Message.MSG_ERROR);
//			msg.setMsgContent("This CourseId or Course Name are required field!");
//			return msg;
//		}
//		if (courseRepository.insert(c)) {
//			Message msg = new Message(Message.MSG_SUCCESS);
//			msg.setMsgContent("Course Insert Successfully");
//			return msg;
//		} else {
//			Message msg = new Message(Message.MSG_ERROR);
//			msg.setMsgContent("Insert Failed");
//			return msg;
//		}
//	}

	

	@Override
	public boolean update(Course c) {
		// int credit = Integer.parseInt(c.getCcredit());
		Course c1 = courseRepository.findOne(c.getCid());
		if (c.getCid() == "" || c.getCid() == null) {

			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("Please input the correct courseid you would like to update!");
			return msg != null;
		}

		if (c1 == null) {
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("The course that you want to update is not exist in the database");
			return msg != null;
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
			return msg != null;

		} else {
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("Update Failed");
			return msg != null;
		}
	}

	@Override
	public boolean delete(String cid) {
		return courseRepository.delete(cid);
	}

	@Override
	public boolean insert(Course c) {
		return courseRepository.insert(c);
	}

}
