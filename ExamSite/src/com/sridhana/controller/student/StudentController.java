package com.sridhana.controller.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sridhana.model.User;

import com.sridhana.service.student.StudentService;
import com.sridhana.bean.ClassBean;
import com.sridhana.model.ClassMap;
import com.sridhana.model.Exam_Details;
import com.sridhana.model.Exam_Grades;
@Controller
public class StudentController {

	@Autowired
	private StudentService  studentService;
	

	@Autowired(required = true)
	@Qualifier(value = "studentService")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/studentclasslinks",method=RequestMethod.GET)
	public ModelAndView setStudentClasslinkspage( HttpServletRequest request, ModelAndView model)
	{
		User user = (User) request.getSession().getAttribute("User");		
		List<ClassMap> classMaplist = studentService.getClassesList(user.getUsername());
		List<ClassBean> classbeanlist = studentService.listClassBean();
		model.addObject("ClassMaplist",classMaplist);
		model.addObject("ClassBeanlist",classbeanlist);
		model.addObject("user", user);
		model.setViewName("Student/StudentClassLinks");
		return model;
	}	
	
	//set remove method to delete question on screen
	@RequestMapping("/studentclassidlinks/{classid}")
	public ModelAndView listExam_DetailsbyClassid(@PathVariable("classid") String classid,HttpServletRequest request, ModelAndView model) {
		User user = (User) request.getSession().getAttribute("User");	
		List<Exam_Details> exam_Details_list= studentService.listExam_DetailsbyClassid(classid);
		List<Exam_Grades> exam_Grades_list = studentService.listExam_GradesbyStudent(classid,user); 
		model.addObject("exam_Details_list",exam_Details_list);
		model.addObject("exam_Grades_list",exam_Grades_list);
		model.setViewName("Student/StudentExamLinks");
		return model;
	}
	
}
