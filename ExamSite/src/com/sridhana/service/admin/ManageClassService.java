package com.sridhana.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.sridhana.DAO.ClassDAO;
import com.sridhana.DAO.CourseDAO;
import com.sridhana.DAO.UserDAO;
import com.sridhana.bean.ClassBean;
import com.sridhana.model.Clas;
import com.sridhana.model.Course;
import com.sridhana.model.User;

@Service
@Transactional
public class ManageClassService {

	@Autowired
	private ClassDAO clsDAO;	

	@Autowired
	@Qualifier(value = "clsDAO")
	public void setClassDAO(ClassDAO clsDAO) {
		this.clsDAO = clsDAO;
	}

	@Autowired
	private UserDAO userDAO;	

	@Autowired
	@Qualifier(value = "userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Autowired
	private CourseDAO courseDAO;	

	@Autowired
	@Qualifier(value = "courseDAO")
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
	
	// Autowiring declarations above -actual code starts from here
	public void addClass(ClassBean classbean) {
		Clas clas =  new Clas();
		Course course = new Course();
		course.setCourseid(classbean.getCourseid());
		course.setCoursename(classbean.getCoursename());
		User user = new User();
		clas.setClassid(classbean.getClassid());
		clas.setCourse(course);
		user.setUsername(classbean.getFacultyusername());
		user.setUsertype("FACULTY");
		clas.setUser(user);
		
		clsDAO.addClass(clas);
	}

	public void updateClass(ClassBean classbean) {
		Clas clas =  new Clas();
		Course course = new Course();
		course.setCourseid(classbean.getCourseid());
		course.setCoursename(classbean.getCoursename());
		User user = new User();
		clas.setClassid(classbean.getClassid());
		clas.setCourse(course);
		user.setUsername(classbean.getFacultyusername());
		user.setUsertype("FACULTY");
		clas.setUser(user);

		clsDAO.updateClass(clas);
	}


	public List<ClassBean> listClass() {
		List<Clas> claslist = clsDAO.listClass();
		
	List<ClassBean> classBeanlist = new ArrayList<ClassBean>();
		
		if (claslist != null ) {
			for (Clas clas : claslist) {

				ClassBean classbean = new ClassBean();
				classbean.setClassid(clas.getClassid());
				classbean.setCourseid(clas.getCourse().getCourseid());
				classbean.setCoursename(clas.getCourse().getCoursename());
				classbean.setFacultyusername(clas.getUser().getUsername());
				classbean.setFirstname(clas.getUser().getFirstname());
				classbean.setLastname(clas.getUser().getLastname());
				classBeanlist.add(classbean);
			}
		}
				return classBeanlist;
		
	}
	
	
	public void deleteClass(ClassBean classbean) {
		Clas clas =  new Clas();
		Course course = new Course();
		course.setCourseid(classbean.getCourseid());
		course.setCoursename(classbean.getCoursename());
		User user = new User();
		clas.setClassid(classbean.getClassid());
		clas.setCourse(course);
		user.setUsername(classbean.getFacultyusername());
		user.setUsertype("FACULTY");
		clas.setUser(user);
		clsDAO.deleteClass(clas);
	
	}
	
	public List<Clas> getClass(String classid) {
		return clsDAO.getClass(classid);
		
	}
	
	public List<String> listallFacultyUsernames()
	{
		return userDAO.listallFacultyUsernames();
	}
	
	public List<String> listAllCourseIds()
	{
		return courseDAO.listallCourseIds();
	}
	
}
