package com.erss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erss.Exception.MessageGenericException;
import com.erss.Models.Faculty;
import com.erss.Services.FacultyService;

@RestController
@RequestMapping("/faculties")
public class FacultyController {

	@Autowired
	FacultyService facultyService;
	
	
	//GET /faculties get all faculties
	@RequestMapping(method= RequestMethod.GET)
	public Object getFaculties(@ModelAttribute Faculty fc){
		return facultyService.find(fc);
	}
	
	//GET /faculties/:fcid search faculty by fcid
	@RequestMapping(value="/{fcid}",method= RequestMethod.GET)
	public Object searchFaculty(@PathVariable String fcid){
		return facultyService.findOne(fcid);
	}
	
	//POST /faculties insert new faculty
	@RequestMapping(method= RequestMethod.POST)
	public Object insertFaculty(@RequestBody Faculty fc) throws MessageGenericException{
		return facultyService.insert(fc);
	}
	
	//PUT /faculties/:fcid update faculty information by fcid
	@RequestMapping(value="/{fcid}",method= RequestMethod.PUT)
	public Object updateFaculty(@PathVariable String fcid,@RequestBody Faculty fc) throws MessageGenericException{
		fc.setFcid(fcid);
		return facultyService.update(fc);
	}
	
	//DELETE /faculties/:fcid delete faculty by fcid
	@RequestMapping(value="/{fcid}",method= RequestMethod.DELETE)
	public Object deleteFaculty(@PathVariable String fcid) throws MessageGenericException{
		Faculty fc = new Faculty();
		fc.setFcid(fcid);
		return facultyService.delete(fc);
	}
}
