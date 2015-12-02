package com.erss.Controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erss.Exception.MessageGenericException;
import com.erss.Models.Message;
import com.erss.Models.Teacher;
import com.erss.Services.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
	
	@Autowired
	TeacherService teacherService; 
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Teacher> getAllTeacher(@RequestBody Teacher t,HttpServletResponse response){
		return teacherService.find(t);
	}
	
	@RequestMapping(value="/{tid}",method=RequestMethod.GET)
	public Teacher getTeacher(@PathVariable("tid")String tid,HttpServletResponse response){
		return  teacherService.findOne(tid);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Message insertTeacher(@RequestBody Teacher t,HttpServletResponse response){
		if(teacherService.insert(t)){
			response.setStatus(response.SC_CREATED);
			return new Message("SUC_TEACHER_INSERT", "Insert new teacher success!");
		}else{
			throw new MessageGenericException("ERR_TEACHER_INSERT", "Failed to insert new teacher!", response.SC_BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{tid}",method=RequestMethod.PUT)
	public Message updateTeacher(
			@PathVariable("id")String tid,
			@RequestBody Teacher t,
			HttpServletResponse response){
		t.setTid(tid);
		if(teacherService.update(t)){
			return new Message("SUC_TEACHER_UPDATE", "Update teacher 'tid : "+tid+"' success!");
		}else{
			throw new MessageGenericException("ERR_TEACHER_UPDATE", "Failed to update teacher 'tid : "+tid+"'", response.SC_BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{tid}",method=RequestMethod.DELETE)
	public Message deleteTeacher(
			@PathVariable("tid")String tid,
			HttpServletResponse response
			){
		if(teacherService.delete(tid)){
			return new Message("SUC_TEACHER_DELETE", "Delete teacher 'tid : "+tid+"' success!");
		}else{
			throw new MessageGenericException("ERR_TEACHER_DELETE", "Failed to delete teacher 'tid : "+tid+"'", response.SC_BAD_REQUEST);
		}
	}
	
	@ExceptionHandler(MessageGenericException.class)
	public Message error(MessageGenericException ex,HttpServletResponse response){
		
		if(ex!=null){
			response.setStatus(ex.getStatusCode());
			return new Message(ex.getErrId(), ex.getErrMsg());
		}
		else{
			response.setStatus(response.SC_INTERNAL_SERVER_ERROR);
			return new Message("ERR_TEACHER_SERVICE", "Unknown error my exception!");
		}
	}
	@ExceptionHandler(Exception.class)
	public Message error(Exception ex,HttpServletResponse response){
		response.setStatus(response.SC_INTERNAL_SERVER_ERROR);
		ex.printStackTrace();
		return new Message("ERR_TEACHER_SERVICE", ex.getMessage());
	}
}
