package com.erss.Services;

import java.util.List;

import com.erss.Models.Historical;
import com.erss.Models.Message;

public interface HistoricalService {
	public Message findOne(int sid, int cid);
	public Message find(String condition);
	public Message insert(Historical h);
	public Message delete(Historical h);
	public Message update(Historical h);

}
