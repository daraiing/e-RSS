package com.erss.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.erss.Exception.MessageGenericException;
import com.erss.Models.Historical;
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
		if(h.getSid() == null || h.getSid().isEmpty() || h.getCid()== null || h.getCid().isEmpty())
		{
			throw new MessageGenericException("ERR_HIS-INSERT", "Primary Key Lost: Either StudentId or CourseId has incorrect input", 400);
		}
		if (historicalRepository.findOne(h.getSid(), h.getCid()) != null) {
			throw new MessageGenericException("ERR_HIS-INSERT", "Data Conflict : Already Exists in the Database", 409);
		}
		System.out.println(historicalRepository.findOne(h.getSid(), h.getCid()) != null);
		return historicalRepository.insert(h);
//		return false;
	}

	@Override
	public boolean delete(String sid, String cid) throws MessageGenericException {

		if(sid == null || sid.isEmpty() ||cid== null || cid.isEmpty())
		{
			throw new MessageGenericException("ERR_HIS-DEL", "Primary Key Lost: Either StudentId or CourseId has incorrect input", 0);
		}
		if(historicalRepository.findOne(sid, cid) == null)
		{
			throw new MessageGenericException("ERR_HIS-DEL", "Undefined Data : Doesn't Exist in the Database", 0);
		}
		return historicalRepository.delete(sid, cid);
	}

	@Override
	public boolean update(Historical h) throws MessageGenericException {
		if(h.getSid() == null || h.getSid().isEmpty() || h.getCid()== null || h.getCid().isEmpty())
		{
			throw new MessageGenericException("ERR_HIS-UPDATE", "Primary Key Lost: Either StudentId or CourseId has incorrect input", 0);
		}
		if (historicalRepository.findOne(h.getSid(), h.getCid()) == null) {
			throw new MessageGenericException("ERR_HIS-UPDATE", "Undefined Data : Doesn't Exists in the Database", 0);
		}
		return historicalRepository.update(h);
	}

	@Override
	public Historical findOne(String sid, String cid) {
		if(sid == null || sid.isEmpty() ||cid== null || cid.isEmpty())
		{
			throw new MessageGenericException("ERR_HIS-SE", "Primary Key Lost: Either StudentId or CourseId has incorrect input", 0);
		}
		if(historicalRepository.findOne(sid, cid) == null)
		{
			throw new MessageGenericException("ERR_HIS-SE", "Undefined Data : Doesn't Exist in the Database", 0);
		}
		return historicalRepository.findOne(sid, cid);
	}

}
