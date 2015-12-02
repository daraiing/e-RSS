package com.erss.Controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.erss.Exception.MessageGenericException;
import com.erss.Models.Historical;
import com.erss.Models.Message;
import com.erss.Services.HistoricalService;

@RestController
@RequestMapping("/History")
public class HistoricalController {
	@Autowired
	HistoricalService historicalService;

	@RequestMapping(method = RequestMethod.POST)
	public Message insertHistory(@RequestBody Historical h, HttpServletResponse response) {
		if (historicalService.insert(h)) {
			response.setStatus(200);
			return new Message("SUC_INSERT", "Insert new History success!");
		} else {
			response.setStatus(400);
			return new Message("ERR_INSERT", "Failed to insert new History!");
		}
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public Message delHistory(@RequestParam("sid") String sid, @RequestParam("cid") String cid,
			HttpServletResponse response) throws MessageGenericException {
		if (historicalService.delete(sid, cid)) {
			response.setStatus(200);
			return new Message("SUC_INSERT", "Successfully Delete from the Database!");
		} else {
			response.setStatus(400);
			return new Message("ERR_INSERT", "Failed to Delete History!");
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Historical> getHistory(@ModelAttribute Historical h)
			throws MessageGenericException {
		return historicalService.find(h);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Message updateHistory(@RequestBody Historical h,HttpServletResponse response) throws MessageGenericException {
		
		if (historicalService.update(h)) {
			response.setStatus(200);
			return new Message("SUC_INSERT", "Successfully Updated!!");
		} else {
			response.setStatus(400);
			return new Message("ERR_INSERT", "Updated Failed!");
		}
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public List<Historical> get1History(@ModelAttribute Historical h) {
		return historicalService.find(h);
	}	

	@ExceptionHandler(MessageGenericException.class)
	public Message error(MessageGenericException ex, HttpServletResponse response) {
		response.setStatus(400);
		if (ex != null)
			return new Message(ex.getErrId(), ex.getErrMsg());
		else
			return new Message("ERR_BTESTSERVICE", "Unknown error my exception!");
	}

	@ExceptionHandler(Exception.class)
	public Message error(Exception ex, HttpServletResponse response) {
		response.setStatus(400);
		return new Message("ERR_BTESTSERVICE", "Something wrong! please check detail in server log.");
	}

}
