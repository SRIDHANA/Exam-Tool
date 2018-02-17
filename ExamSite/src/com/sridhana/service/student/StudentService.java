package com.sridhana.service.student;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sridhana.DAO.ClassDAO;
import com.sridhana.DAO.ClassMapDAO;
import com.sridhana.DAO.Exam_DetailsDAO;
import com.sridhana.DAO.Exam_GradesDAO;
import com.sridhana.bean.ClassBean;
import com.sridhana.model.Clas;
import com.sridhana.model.ClassMap;
import com.sridhana.model.Exam_Details;
import com.sridhana.model.Exam_Grades;
import com.sridhana.model.User;


@Service
@Transactional
public class StudentService {

	@Autowired
	private ClassMapDAO classMapDAO;	

	@Autowired
	@Qualifier(value = "classMapDAO")
	public void setClassMapDAO(ClassMapDAO classMapDAO) {
		this.classMapDAO = classMapDAO;
	}

	@Autowired
	private ClassDAO classDAO;	

	@Autowired
	@Qualifier(value = "classDAO")
	public void setClassDAO(ClassDAO classDAO) {
		this.classDAO = classDAO;
	}

	@Autowired
	private Exam_DetailsDAO exam_DetailsDAO;	

	@Autowired
	@Qualifier(value = "exam_DetailsDAO")
	public void setExam_DetailsDAO(Exam_DetailsDAO exam_DetailsDAO) {
		this.exam_DetailsDAO = exam_DetailsDAO;
	}

	@Autowired
	private Exam_GradesDAO exam_GradesDAO;	

	@Autowired
	@Qualifier(value = "exam_GradesDAO")
	public void setExam_GradesDAO(Exam_GradesDAO exam_GradesDAO) {
		this.exam_GradesDAO = exam_GradesDAO;
	}



	public List<ClassBean> listClassBean() {
		
		List<Clas> claslist =  classDAO.listClass();
	  
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
	
	
	// Autowiring declarations above -actual code starts from here
	public List<ClassMap> getClassesList(String username) {
		return classMapDAO.getClassMapbyUsername(username);
	}
	
	@SuppressWarnings("unchecked")
	public List<Clas> listClass() {
		return classDAO.listClass();	
	}
	
	public List<Exam_Details> listExam_DetailsbyClassid(String classid) {
		return exam_DetailsDAO.listExam_DetailsbyClassid(classid);		
	}	
	
	public List<Exam_Grades> listExam_GradesbyStudent(String classid,User user ) {
		return exam_GradesDAO.listExam_GradesbyStudent(classid, user);
	}	
	
}

