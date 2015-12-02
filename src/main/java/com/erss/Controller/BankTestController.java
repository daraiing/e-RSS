package com.erss.Controller;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.erss.Exception.MessageGenericException;
import com.erss.Models.Message;
import com.erss.Models.Teacher;
import com.erss.Services.TeacherService;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/b")
public class BankTestController {
	@Autowired
	TeacherService tService;

	@RequestMapping(value="/{tid}",method=RequestMethod.GET)
	public Teacher getTeacher(@PathVariable("tid")String tid,HttpServletResponse response) throws MessageGenericException{
		Teacher t = tService.findOne(tid);
		if(t!=null){
			response.setStatus(200);
			return t;
		}else{
			throw new MessageGenericException("BTS_404", "not found 'tid:"+tid+"'");
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Message insertTeacher(@RequestBody Teacher t,HttpServletResponse response){
		if(tService.insert(t)){
			response.setStatus(201);
			return new Message("SUC_INSERT", "Insert new teacher success!");
		}else{
			response.setStatus(400);
			return new Message("ERR_INSERT", "Failed to insert new teacher!");
		}
	}
	
	
	@ExceptionHandler(MessageGenericException.class)
	public Message error(MessageGenericException ex,HttpServletResponse response){
		response.setStatus(400);
		if(ex!=null)return new Message(ex.getErrid(), ex.getErrmsg());
		else return new Message("ERR_BTESTSERVICE", "Unknown error my exception!");
	}
	@ExceptionHandler(Exception.class)
	public Message error(Exception ex,HttpServletResponse response){
		response.setStatus(400);
		return new Message("ERR_BTESTSERVICE", "Something wrong! please check detail in server log.");
	}
}
