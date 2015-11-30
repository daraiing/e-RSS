package com.erss.Repositories;

import com.erss.Models.Historical;

/**
 * 
 * @author darathorn.t
 *
 */
public interface HistoricalRepository {
	
	public Historical findOne(int sid, int cid);
	public Historical findBySid(String sid, String condition);
	public boolean insert(Historical h);
	public boolean delete(String sid, String cid);

}
