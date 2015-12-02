package com.erss.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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
			return false;
		}
		else {
			return facultyRepository.insert(f);
		}
	}

	@Override
	public boolean delete(Faculty f) {
		if (facultyRepository.findOne(f.getFcid()) != null) {
			return facultyRepository.delete(f);
		}
		else {
			return false;
		}
	}

	@Override
	public boolean update(Faculty f) {
		if (facultyRepository.findOne(f.getFcid()) != null) {
			return facultyRepository.update(f);
		}
		else {
			return false;
		}
	}

}
