package edu.npu.zu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.npu.zu.domain.Student;
import edu.npu.zu.services.StudentServiceI;

/*  Use the following URL for this Controller:  
 *        http://localhost:8080/zuniversity/student/idlookup    (to lookup a student with the student id)
*/
@RequestMapping("/student")  // sets the base url for all controller methods in this class
@Controller
public class StudentController {
	private final StudentServiceI studentService;

	@Autowired
	public StudentController(StudentServiceI studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping(value = "/idlookup", method = RequestMethod.GET)
	public String presentLookupStudentByIdForm() {
		return "students/lookupStudentByIdForm";
	}
	
	@RequestMapping(value = "/executeidlookup", method = RequestMethod.POST)
	public ModelAndView listStudentsInCourse(int studentId) {
		ModelAndView modelView;
		Student student;
		
		try {  /* always be prepared for something to go wrong!  */
			student = studentService.getStudentWithId(studentId);
		} catch (Exception ex) {
			modelView = new ModelAndView("error");
			modelView.addObject("exception", ex);
			return modelView;
		}
		
		modelView = new ModelAndView("students/viewStudentFromLookup");
		modelView.addObject("student", student);
		if (student == null) {
			modelView.addObject("badStudentId", studentId);
		} 
		
		return modelView;
	}
	
}
