package com.erss.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.erss.Models.Message;
import com.erss.Models.Student;
import com.erss.Repositories.StudentRepository;
import com.erss.Util.Crypto;

public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student findOne(String sid) {
		// TODO Auto-generated method stub
		return null;
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
	public boolean insert(Student st) {
		if (studentRepository.findOne(st.getSid()) != null) {
			return false;
		}
		String password = st.getPassword();
		st.setPassword(Crypto.SHA1(password));
		if (studentRepository.insert(st)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean delete(Student st) {
		if (studentRepository.findOne(st.getSid()) != null) {
			studentRepository.delete(st);
			return true;
		}
		else return false;
	}

	@Override
	public boolean update(Student st) {
		if (studentRepository.findOne(st.getSid()) != null) {
			studentRepository.update(st);
			return true;
		}
		else return false;
	}

}
