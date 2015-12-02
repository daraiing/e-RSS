package com.erss.Services;

import java.util.List;

import com.erss.Exception.MessageGenericException;
import com.erss.Models.Historical;
import com.erss.Models.Message;

public interface HistoricalService {
	public Historical findOne(String sid, String cid);
	public List<Historical> find(Historical h);
	public boolean insert(Historical h) throws MessageGenericException;
	public boolean delete(String sid, String cid) throws MessageGenericException;
	public boolean update(Historical h) throws MessageGenericException;

}
