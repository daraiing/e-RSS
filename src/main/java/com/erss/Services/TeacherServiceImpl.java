package com.erss.Services;

import org.springframework.beans.factory.annotation.Autowired;

import com.erss.Models.Message;
import com.erss.Models.Teacher;
import com.erss.Repositories.TeacherRepository;
import com.erss.Util.Crypto;

public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherRepository teacherRepository; 
	

	@Override
	public Message find(Teacher t) {
		Message msg = new Message(Message.MSG_SUCCESS);
		msg.setMsgContent(teacherRepository.find(t));
		return msg;
	}

	@Override
	public Message insert(Teacher t) {
		if (teacherRepository.findOne(t.getTid())!=null) {
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("This 'tid:"+t.getTid()+"' already exist in the database");
			return msg;
		}
		String password = t.getPassword();
		t.setPassword(Crypto.SHA1(password));
		if (teacherRepository.insert(t)) {
			Message msg = new Message(Message.MSG_SUCCESS);
			msg.setMsgContent("Teacher 'tid:"+t.getTid()+"' insert successfully");
			return msg;
		} else {
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("Insert failed");
			return msg;
		}
	}

	@Override
	public Message delete(Teacher t) {
		if(teacherRepository.findOne(t.getTid())!=null){
			if(teacherRepository.delete(t)){
				Message msg = new Message(Message.MSG_SUCCESS);
				msg.setMsgContent("Teacher 'tid:"+t.getTid()+"' drop successfully");
				return msg;
			}else{
				Message msg = new Message(Message.MSG_ERROR);
				msg.setMsgContent("Teacher 'tid:"+t.getTid()+"' drop failed!");
				return msg;
			}
		}else{
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("Teacher 'tid:"+t.getTid()+"' not define!");
			return msg;
		}
		
	}

	@Override
	public Message update(Teacher t) {
		Teacher tOld = teacherRepository.findOne(t.getTid());
		if(tOld!=null){
			if(t.getFname()!=null || !t.getFname().isEmpty())tOld.setFname(t.getFname());
			if(t.getLname()!=null || !t.getLname().isEmpty())tOld.setLname(t.getLname());
			if(t.getField()!=null || !t.getField().isEmpty())tOld.setField(t.getField());
			if(t.getPassword()!=null || !t.getPassword().isEmpty())tOld.setFname(Crypto.SHA1(t.getPassword()));
			if(t.getTitle()!=null || !t.getTitle().isEmpty())tOld.setTitle(t.getTitle());
			
			if(teacherRepository.update(tOld)){
				Message msg = new Message(Message.MSG_ERROR);
				msg.setMsgContent("Teacher 'tid:"+t.getTid()+"' update success!");
				return msg;
			}else{
				Message msg = new Message(Message.MSG_ERROR);
				msg.setMsgContent("Teacher 'tid:"+t.getTid()+"' update failed!");
				return msg;
			}
		}else{
			Message msg = new Message(Message.MSG_ERROR);
			msg.setMsgContent("Teacher 'tid:"+t.getTid()+"' not define!");
			return msg;
		}
	}

}
