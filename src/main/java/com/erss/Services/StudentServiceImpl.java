package com.erss.Services;

import org.springframework.beans.factory.annotation.Autowired;

import com.erss.Models.Message;
import com.erss.Models.Student;
import com.erss.Repositories.StudentRepository;
import com.erss.Util.Crypto;

public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Message findOne(String sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message find(Student st) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message findByAdvisor(String tid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message insert(Student st) {
		if (studentRepository.findOne(st.getSid())!=null) {
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("This StudentId Already Exist in the Database");
			return msg;
		}
		String password = st.getPassword();
		st.setPassword(Crypto.SHA1(password));
		if (studentRepository.insert(st)) {
			Message msg = new Message(Message.MSG_SUCCESS);
			msg.setMsgContent("Student Insert Successfully");
			return msg;
		} else {
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("Insert Failed");
			return msg;
		}

	}

	@Override
	public Message delete(Student st) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message update(Student st) {
		// TODO Auto-generated method stub
		return null;
	}

}
