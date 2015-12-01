package com.erss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	@RequestMapping(value="insert", method= RequestMethod.POST)
	public Message insertStudent(@ModelAttribute Student st)
	{	
		Message message = studentService.insert(st);
		return message;
	}
	
	@RequestMapping(method= RequestMethod.GET)
	public Object searchStudent(@ModelAttribute Student st)
	{	
		return studentService.find(st);
	}
	
	
	@RequestMapping(value="check", method= RequestMethod.POST)
	public Object validation(@ModelAttribute Student st)
	{
		Message message = validationService.validation(st.getSid(), st.getPassword());
		return message;
	}

}
