package com.sridhana.service.faculty;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sridhana.DAO.ClassDAO;
import com.sridhana.DAO.Exam_DetailsDAO;
import com.sridhana.DAO.Exam_GradesDAO;
import com.sridhana.bean.ClassBean;
import com.sridhana.model.Clas;
import com.sridhana.model.Exam_Details;
import com.sridhana.model.Exam_Grades;
import com.sridhana.model.User;

@Service
@Transactional
public class FacultyService {

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
	public List<ClassBean> getClassbyFacultyUsername(User user) {
		List<Clas> claslist =  classDAO.getClassbyFacultyUsername(user);
	  
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
	
	public List<Exam_Details> listExam_DetailsbyClassid(String classid) {
		return exam_DetailsDAO.listExam_DetailsbyClassid(classid);		
	}	
	
//	public List<Exam_Grades> listExam_GradesbyClassid(String classid ) {
//		return exam_GradesDAO.listExam_GradesbyClassid(classid);
//	}
//	
	public List<Exam_Grades> listExam_GradesbyExamid(String examid ) {
		return exam_GradesDAO.listExam_GradesbyExamid(examid);
	}
	
	
	public void addExam_Details(Exam_Details exam_details ) {
		exam_DetailsDAO.addExam_Details(exam_details);
	}
	public void updateExam_Details(Exam_Details exam_details) {
		exam_DetailsDAO.updateExam_Details(exam_details);
	}
	public void deleteExam_Details(Exam_Details exam_details) {
		exam_DetailsDAO.deleteExam_Details(exam_details);	
	}
	
	
	
}
