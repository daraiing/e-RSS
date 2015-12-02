package com.erss.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.erss.Exception.MessageGenericException;
import com.erss.Models.Faculty;
import com.erss.Repositories.FacultyRepository;

public class FacultyServiceImpl implements FacultyService {

	@Autowired
	FacultyRepository facultyRepository;

	@Override
	public Faculty findOne(String fcid) {
		return facultyRepository.findOne(fcid);
	}

	@Override
	public List<Faculty> find(Faculty fc) {
		return facultyRepository.find(fc);
	}

	@Override
	public boolean insert(Faculty f) {
		if (facultyRepository.findOne(f.getFcid()) != null) {
			throw new MessageGenericException("ERR_FC-INSERT", "already exist in the database", 409);
		} else {
			return facultyRepository.insert(f);
		}
	}

	@Override
	public boolean delete(Faculty f) {
		if (facultyRepository.findOne(f.getFcid()) != null) {
			return facultyRepository.delete(f);
		} else {
			throw new MessageGenericException("ERR_FC-DEL", "'fcid:" + f.getFcid() + "' not define!", 409);
		}
	}

	@Override
	public boolean update(Faculty f) {
		if (facultyRepository.findOne(f.getFcid()) != null) {
			return facultyRepository.update(f);
		} else {
			throw new MessageGenericException("ERR_FC-UPDATE", "'fcid:" + f.getFcid() + "' not define!", 409);
		}
	}

}
