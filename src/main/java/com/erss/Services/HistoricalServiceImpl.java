package com.erss.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.erss.Exception.MessageGenericException;
import com.erss.Models.Historical;
import com.erss.Models.Message;
import com.erss.Repositories.HistoricalRepository;

public class HistoricalServiceImpl implements HistoricalService {

	@Autowired
	HistoricalRepository historicalRepository;

	@Override
	public List<Historical> find(Historical h) {
		return historicalRepository.find(h);
	}

	@Override
	public boolean insert(Historical h) throws MessageGenericException {
		return historicalRepository.insert(h);
	}

	@Override
	public boolean delete(String sid, String cid) throws MessageGenericException {

		return historicalRepository.delete(sid,cid);
	}

	@Override
	public boolean update(Historical h) throws MessageGenericException {
		return historicalRepository.update(h);
	}

	@Override
	public Historical findOne(String sid, String cid) {
		return historicalRepository.findOne(sid, cid);
	}

}
