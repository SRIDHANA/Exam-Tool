package com.sridhana.DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sridhana.model.Exam_Details;
import com.sridhana.model.Exam_Grades;
import com.sridhana.model.User;


@Repository
public class Exam_GradesDAO {


	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	
	// Autowiring declarations above -actual code starts here
	public void addExam_Grades(Exam_Grades exam_grades ) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(exam_grades);
		System.out.println("Added Exam_Grades");		
	}

	public void updateExam_Grades(Exam_Grades exam_grades) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(exam_grades);
		System.out.println("Updated Exam_Grades");		

	}

	@SuppressWarnings("unchecked")
	public List<Exam_Grades> listExam_Grades() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Exam_Grades> Exam_GradesList = session.createQuery("from Exam_Grades").list();
		System.out.println("Listed exam_grades");		
		return Exam_GradesList;
	}
		
	public void deleteExam_Grades(Exam_Grades exam_grades) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(exam_grades);
		tx.commit();
		session.close();
		System.out.println("Deleted exam_grades");
	}
		
	@SuppressWarnings("unchecked")
	public List<Exam_Grades> listExam_GradesbyStudent(String classid,User user ) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql="from Exam_Grades as a where a.classid =:classid and a.studentusername=:username";
		Query query=session.createQuery(hql);
		query.setString("classid", classid);
		query.setString("username",user.getUsername());
		List<Exam_Grades> Exam_GradesList =query.list();
		System.out.println("Listed exam_grades");		
		return Exam_GradesList;
	}

	@SuppressWarnings("unchecked")
	public List<Exam_Grades> listExam_GradesbyExamid(String examid ) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql="from Exam_Grades as a where a.examid =:examid ";
		Query query=session.createQuery(hql);
		query.setString("examid", examid);
		List<Exam_Grades> Exam_GradesList =query.list();
		System.out.println("Listed exam_grades");		
		return Exam_GradesList;
	}



}
