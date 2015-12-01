package com.erss.Services;

import java.util.List;

import com.erss.Models.Historical;
import com.erss.Models.Message;

public interface HistoricalService {
	public Historical findOne(int sid, int cid);
	public List<Historical> find(String condition);
	public boolean insert(Historical h);
	public boolean delete(Historical h);
	public boolean update(Historical h);

}
