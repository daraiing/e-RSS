package com.erss.Controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erss.Exception.MessageGenericException;
import com.erss.Models.Message;
import com.erss.Models.Student;
import com.erss.Services.StudentService;
import com.erss.Services.ValidationService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	@Autowired
	ValidationService validationService;

	// GET /student return all student
	@RequestMapping(method = RequestMethod.GET)
	public Object getStudents(@ModelAttribute Student st) {
		return studentService.find(st);
	}

	// GET /student/:sid search student by id
	@RequestMapping(value = "/{sid}", method = RequestMethod.GET)
	public Object searchStudent(@PathVariable String sid) {
		return studentService.findOne(sid);
	}
	
	// POST /student create new student
	@RequestMapping(method = RequestMethod.POST)
	public Object insertStudent(@RequestBody Student st) throws MessageGenericException {
		return studentService.insert(st);
	}


	// PUT /student/:sid update student information by sid
	@RequestMapping(value = "/{sid}", method = RequestMethod.PUT)
	public Object updateStudent(@PathVariable String sid, @RequestBody Student st) throws MessageGenericException {
		st.setSid(sid);
		return studentService.update(st);
	}

	// DELETE /student/:sid delete student by sid
	@RequestMapping(value = "/{sid}", method = RequestMethod.DELETE)
	public Object deleteStudent(@PathVariable String sid) throws MessageGenericException {
		Student st = new Student();
		st.setSid(sid);
		return studentService.delete(st);
	}

	// @RequestMapping(value="check", method= RequestMethod.POST)
	// public Object validation(@ModelAttribute Student st)
	// {
	// Message message = validationService.validation(st.getSid(),
	// st.getPassword());
	// return message;
	// }

	@ExceptionHandler(MessageGenericException.class)
	public Message error(MessageGenericException ex,HttpServletResponse response){
		if(ex!=null){
			response.setStatus(ex.getStatusCode());
			return new Message(ex.getErrId(), ex.getErrMsg());
		}
		else return new Message("ERR_STUDENT_SERVICE", "Unknown error my exception!");
	}
	@ExceptionHandler(Exception.class)
	public Message error(Exception ex,HttpServletResponse response){
		return new Message("ERR_STUDENT_SERVICE", "Something wrong! please check detail in server log.");
	}
	
}
