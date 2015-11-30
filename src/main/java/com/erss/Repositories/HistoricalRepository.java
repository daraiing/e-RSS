package com.erss.Repositories;

import java.util.List;

import com.erss.Models.Historical;

/**
 * 
 * @author darathorn.t
 *
 */
public interface HistoricalRepository {
	
	public Historical findOne(int sid, int cid);
	public List<Historical> find(String condition);
	public boolean insert(Historical h);
	public boolean delete(Historical h);
	public boolean update(Historical h);

}
