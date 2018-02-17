package com.sridhana.DAO;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sridhana.model.Exam_Details;
import com.sridhana.model.User;

public class Exam_DetailsDAO {

		@Autowired
		private SessionFactory sessionFactory;

		public void setSessionFactory(SessionFactory sf) {
			this.sessionFactory = sf;
		}
	
		// Autowiring declarations above -actual code starts here
		public void addExam_Details(Exam_Details exam_details ) {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(exam_details);
			System.out.println("Added Exam_Details");		
		}

		public void updateExam_Details(Exam_Details exam_details) {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(exam_details);
			System.out.println("Updated Exam_Details");		

		}

		@SuppressWarnings("unchecked")
		public List<Exam_Details> listExam_Details() {
			Session session = this.sessionFactory.getCurrentSession();
			List<Exam_Details> Exam_DetailsList = session.createQuery("from Exam_Details").list();
			System.out.println("Listed exam_details");		
			return Exam_DetailsList;
		}
		@SuppressWarnings("unchecked")
		public List<Exam_Details> listExam_DetailsbyClassid(String classid) {
			Session session = this.sessionFactory.getCurrentSession();
			String hql="from Exam_Details as a where a.classid=:P_classid";
			Query query=session.createQuery(hql);
			query.setString("P_classid", classid);
			System.out.println("Query String: ==> " + query.getQueryString());
			List<Exam_Details> Exam_DetailsList =query.list();
			System.out.println("Listed exam_details");		
			return Exam_DetailsList;
		}

		public void deleteExam_Details(Exam_Details exam_details) {
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.delete(exam_details);
			tx.commit();
			session.close();
			System.out.println("Deleted exam_details");
		}
			
		


	}
	
