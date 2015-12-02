package com.erss.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.erss.Exception.MessageGenericException;
import com.erss.Models.Message;
import com.erss.Models.Teacher;
import com.erss.Repositories.TeacherRepository;
import com.erss.Util.Crypto;

public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherRepository teacherRepository; 
	
	

	@Override
	public List<Teacher> find(Teacher t) {
		return teacherRepository.find(t);
	}

	@Override
	public boolean insert(Teacher t) throws MessageGenericException {
		if (teacherRepository.findOne(t.getTid())!=null) {
			throw new MessageGenericException("ERR_TE-INSERT", "already exist in the database");
		}
		String password = t.getPassword();
		t.setPassword(Crypto.SHA1(password));
		return teacherRepository.insert(t);
	}

	@Override
	public boolean delete(Teacher t) throws MessageGenericException {
		if(teacherRepository.findOne(t.getTid())!=null){
			return teacherRepository.delete(t);
		}else{
			throw new MessageGenericException("ERR_TE-DEL", "'tid:"+t.getTid()+"' not define!");
		}
		
	}

	@Override
	public boolean update(Teacher t) throws MessageGenericException {
		Teacher tOld = teacherRepository.findOne(t.getTid());
		if(tOld!=null){
			if(t.getFname()!=null || !t.getFname().isEmpty())tOld.setFname(t.getFname());
			if(t.getLname()!=null || !t.getLname().isEmpty())tOld.setLname(t.getLname());
			if(t.getField()!=null || !t.getField().isEmpty())tOld.setField(t.getField());
			if(t.getPassword()!=null || !t.getPassword().isEmpty())tOld.setFname(Crypto.SHA1(t.getPassword()));
			if(t.getTitle()!=null || !t.getTitle().isEmpty())tOld.setTitle(t.getTitle());
			return teacherRepository.update(tOld);
		}else{
			throw new MessageGenericException("ERR_TE-UPDATE", "'tid:"+t.getTid()+"' not define!");
		}
	}

	@Override
	public Teacher findOne(String tid) {
		Teacher t = new Teacher();
		t.setTid(tid);
		return teacherRepository.findOne(tid);
	}

}
