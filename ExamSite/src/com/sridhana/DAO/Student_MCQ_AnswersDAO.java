package com.sridhana.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sridhana.model.Student_MCQ_Answers;

@Repository
public class Student_MCQ_AnswersDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	// Autowiring declarations above -actual code starts here
	public void addStudent_MCQ_Answers(Student_MCQ_Answers student_mcq_answers ) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(student_mcq_answers);
		System.out.println("Added Student_MCQ_Answers");		
	}

	public void updateStudent_MCQ_Answers(Student_MCQ_Answers student_mcq_answers) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(student_mcq_answers);
		System.out.println("Updated Student_MCQ_Answers");		

	}

	@SuppressWarnings("unchecked")
	public List<Student_MCQ_Answers> listStudent_MCQ_Answers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Student_MCQ_Answers> Student_MCQ_AnswersList = session.createQuery("from Student_MCQ_Answers").list();
		System.out.println("Listed student_mcq_answers");		
		return Student_MCQ_AnswersList;
	}
		
	public void deleteStudent_MCQ_Answers(Student_MCQ_Answers student_mcq_answers) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(student_mcq_answers);
		tx.commit();
		session.close();
		System.out.println("Deleted student_mcq_answers");
	}
		
	
	
	
	
}
