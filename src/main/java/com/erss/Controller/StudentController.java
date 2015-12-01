package com.erss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erss.Models.Message;
import com.erss.Models.Student;
import com.erss.Services.StudentService;
import com.erss.Services.ValidationService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	@Autowired
	ValidationService validationService;
	
	@RequestMapping(value="insert", method= RequestMethod.POST)
	public @ResponseBody Message insertStudent(@ModelAttribute Student student)
	{
		Message message = studentService.insert(student);
		return message;
	}
	
	@RequestMapping(value="check", method= RequestMethod.POST)
	public @ResponseBody Object validation(@ModelAttribute Student student)
	{
		Message message = validationService.validation(student.getSid(), student.getPassword());
		return message;
	}

}
