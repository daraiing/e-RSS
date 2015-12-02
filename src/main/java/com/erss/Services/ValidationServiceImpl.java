package com.erss.Services;

import org.springframework.beans.factory.annotation.Autowired;

import com.erss.Exception.MessageGenericException;
import com.erss.Models.Student;
import com.erss.Models.Teacher;
import com.erss.Repositories.StudentRepository;
import com.erss.Repositories.TeacherRepository;
import com.erss.Util.Crypto;

public class ValidationServiceImpl implements ValidationService {

	@Autowired
	StudentRepository studentRepository;
	
	TeacherRepository teacherRepository;

	@Override
	public Student validationStudent(String sid, String password) throws MessageGenericException {
		Student st = studentRepository.findOne(sid);
		if (st != null) {
			if (st.getPassword().equals(Crypto.SHA1(password))) {
				return st;
			} else {
				throw new MessageGenericException("VID_ERROR", "Passwrong is wrong!", 401);
			}
		} else {
			throw new MessageGenericException("VID_ERROR", "Student ID is invalid.", 409);
		}
	}

	@Override
	public Teacher validationTeacher(String tid, String password) throws MessageGenericException {
		Teacher st = teacherRepository.findOne(tid);
		if (st != null) {
			if (st.getPassword().equals(Crypto.SHA1(password))) {
				return st;
			} else {
				throw new MessageGenericException("VID_ERROR", "Passwrong is wrong!", 401);
			}
		} else {
			throw new MessageGenericException("VID_ERROR", "Teacher ID is invalid.", 409);
		}
	}

}
