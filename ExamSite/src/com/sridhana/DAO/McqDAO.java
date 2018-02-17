package com.sridhana.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sridhana.model.Exam_Grades;
import com.sridhana.model.Mcq;

@Repository
public class McqDAO {
		
		@Autowired
		private SessionFactory sessionFactory;

		public void setSessionFactory(SessionFactory sf) {
			this.sessionFactory = sf;
		}
		
		// Autowiring declarations above -actual code starts here
		public void addMcq(Mcq mcq ) {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(mcq);
			System.out.println("Added Mcq");		
		}

		public void updateMcq(Mcq mcq) {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(mcq);
			System.out.println("Updated Mcq");		

		}

		@SuppressWarnings("unchecked")
		public List<Mcq> listMcq() {
			Session session = this.sessionFactory.getCurrentSession();
			List<Mcq> McqList = session.createQuery("from Mcq").list();
			System.out.println("Listed mcq");		
			return McqList;
		}
		
		@SuppressWarnings("unchecked")
		public List<Mcq> listMcqbyExamid(String examid) {
			Session session = this.sessionFactory.getCurrentSession();
			String hql="from Mcq as a where a.examid =: examid";
			Query query=session.createQuery(hql);
			query.setString("examid", examid);
			List<Mcq> McqList =query.list();
			System.out.println("Listed mcq");		
			return McqList;
		}
		
		public void deleteMcq(Mcq mcq) {
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.delete(mcq);
			tx.commit();
			session.close();
			System.out.println("Deleted mcq");
		}
			
		
		
	}

