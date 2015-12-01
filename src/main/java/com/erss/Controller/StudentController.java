package com.erss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erss.Models.Message;
import com.erss.Models.Student;
import com.erss.Services.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	@RequestMapping(value="insert", method= RequestMethod.POST)
	public @ResponseBody Message insertStudent(Student student)
	{
		Message message = studentService.insert(student);
		return message;
	}

}
