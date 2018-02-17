package com.sridhana.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sridhana.model.Clas;
import com.sridhana.model.User;

@Repository
public class ClassDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	// Autowiring declarations above -actual code starts here

	public void addClass(Clas cls ) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(cls);
		System.out.println("Added Clas");		
	}

	public void updateClass(Clas cls) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(cls);
		System.out.println("Updated Clas");		

	}
	
	@SuppressWarnings("unchecked")
	public List<Clas> listClass() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Clas> ClassList = session.createQuery("from Clas").list();
		System.out.println("Listed class");		
		return ClassList;
	}
		
	public void deleteClass(Clas cls) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(cls);
		tx.commit();
		session.close();
		System.out.println("Deleted class");
	}
		
	
	public List<Clas> getClass(String classid) {
		Session session=sessionFactory.openSession();
		String hql="from Clas as a where a.classid=:classid";
		Query query=session.createQuery(hql);
		query.setString("classid", classid);
		@SuppressWarnings("unchecked")
		List<Clas> data=query.list();
		System.out.println("got class by classid");
		return data;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Clas> getClassbyFacultyUsername(User user) {
		Session session=sessionFactory.openSession();
		System.out.println("gET CLASS BY USERNAME USER : "+ user.getUsername() );
		String hql="from Clas as a where a.user.username=:P_username";
		Query query=session.createQuery(hql);
		query.setString("P_username", user.getUsername());
		System.out.println("Query String ==> : " + query.getQueryString());
		List<Clas> data=query.list();		
		System.out.println("got class by classid");
		return data;
	}	
	
}
