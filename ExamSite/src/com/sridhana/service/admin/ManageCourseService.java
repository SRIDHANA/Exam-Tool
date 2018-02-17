package com.sridhana.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.sridhana.DAO.CourseDAO;
import com.sridhana.model.Course;

@Service
@Transactional
public class ManageCourseService {

	@Autowired
	private CourseDAO courseDAO;	

	@Autowired
	@Qualifier(value = "courseDAO")
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	// Autowiring declarations above -actual code starts from here
	public void addCourse(Course course) {
		courseDAO.addCourse(course);
	}

	public void updateCourse(Course course) {
		courseDAO.updateCourse(course);
	}


	public List<Course> listCourse() {
		return courseDAO.listCourse();
	}
	
	public void deleteCourse(Course course) {
		courseDAO.deleteCourse(course);
	
	}
	
	public List<Course> getCourse(String courseid) {
		return courseDAO.getCourse(courseid);
		
	}
	
}
