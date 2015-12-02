package com.erss.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.erss.Exception.MessageGenericException;
import com.erss.Models.Student;
import com.erss.Repositories.StudentRepository;
import com.erss.Util.Crypto;

public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student findOne(String sid) {
		return studentRepository.findOne(sid);
	}

	@Override
	public List<Student> find(Student st) {
		return studentRepository.find(st);
	}

	@Override
	public List<Student> findByAdvisor(String tid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Student st) throws MessageGenericException {
		if (studentRepository.findOne(st.getSid()) != null) {
			throw new MessageGenericException("ERR_TE-INSERT", "already exist in the database");
		}
		String password = st.getPassword();
		st.setPassword(Crypto.SHA1(password));
		return studentRepository.insert(st);

	}

	@Override
	public boolean delete(Student st) throws MessageGenericException {
		if (studentRepository.findOne(st.getSid()) != null) {
			return studentRepository.delete(st);
		} else
			throw new MessageGenericException("ERR_TE-DEL", "'sid:" + st.getSid() + "' not define!");
	}

	@Override
	public boolean update(Student st) throws MessageGenericException {
		if (studentRepository.findOne(st.getSid()) != null) {
			Student o_st = studentRepository.findOne(st.getSid());
			if(st.getFname()==null)st.setFname(o_st.getFname());
			if(st.getLname()==null)st.setLname(o_st.getLname());
			if(st.getPassword()==null)
				st.setPassword(o_st.getPassword());
			else{
				String password = st.getPassword();
				st.setPassword(Crypto.SHA1(password));
			}
			if(st.getTid()==null)st.setTid(o_st.getTid());
			if(st.getFcid()==null)st.setFcid(o_st.getFcid());
			if(st.getTitle()==null)st.setTitle(o_st.getTitle());
			if(st.getGender()==null)st.setGender(o_st.getGender());
			if(st.getYear()==0)st.setYear(o_st.getYear());
			return studentRepository.update(st);
		} else
			throw new MessageGenericException("ERR_TE-DEL", "'sid:" + st.getSid() + "' not define!");
	}

}
