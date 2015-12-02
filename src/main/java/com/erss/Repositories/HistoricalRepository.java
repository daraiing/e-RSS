package com.erss.Repositories;

import java.util.List;

import com.erss.Models.Historical;

/**
 * 
 * @author darathorn.t
 *
 */
public interface HistoricalRepository {
	
	public Historical findOne(String sid,String cid);
	public List<Historical> find(Historical h);
	public boolean insert(Historical h);
	public boolean delete(String cid,String sid);
	public boolean update(Historical h);
}
