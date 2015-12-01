package com.erss.Services;

import org.springframework.beans.factory.annotation.Autowired;

import com.erss.Models.Message;
import com.erss.Models.Student;
import com.erss.Repositories.StudentRepository;
import com.erss.Util.Crypto;

public class ValidationServiceImpl implements ValidationService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Message validation(String sid, String password) {
		Student st = studentRepository.findOne(sid);
		if (st != null) {
			if (st.getPassword().equals(Crypto.SHA1(password))) {
				Message msg = new Message(Message.MSG_SUCCESS);
				msg.setMsgContent("Welcome\n" + st.getTitle()+" "+st.getFname()+" "+st.getLname());
				return msg;
			} else {
				Message msg = new Message(Message.MSG_ERROR);
				msg.setMsgContent("Password is wrong");
				return msg;
			}
		} else {
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("Student ID is invalid.");
			return msg;
		}
	}

}
