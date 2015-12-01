package com.erss.Services;

import java.util.List;

import com.erss.Exception.MessageGenericException;
import com.erss.Models.Historical;
import com.erss.Models.Message;

public interface HistoricalService {
	public Historical findOne(int sid, int cid);
	public List<Historical> find(String condition);
	public boolean insert(Historical h) throws MessageGenericException;
	public boolean delete(Historical h) throws MessageGenericException;
	public boolean update(Historical h) throws MessageGenericException;

}
