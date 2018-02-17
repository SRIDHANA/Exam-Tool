package com.sridhana.DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sridhana.model.ClassMap;

@Repository
public class ClassMapDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	// Autowiring declarations above -actual code starts here

	public void addClassMap(ClassMap classmap ) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(classmap);
		System.out.println("Added ClassMap");		
	}

	public void updateClassMap(ClassMap classmap) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(classmap);
		System.out.println("Updated ClassMap");		

	}
	
	@SuppressWarnings("unchecked")
	public List<ClassMap> listClassMap() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ClassMap> ClassMapList = session.createQuery("from ClassMap").list();
		System.out.println("Listed class");		
		return ClassMapList;
	}
		
	public void deleteClassMap(ClassMap classmap) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(classmap);
		tx.commit();
		session.close();
		System.out.println("Deleted class");
	}
		
	
	public List<ClassMap> getClassMapbyclassid(String classid) {
		Session session=sessionFactory.openSession();
		String hql="from ClassMap as a where a.classid=:classid";
		Query query=session.createQuery(hql);
		query.setString("classid", classid);
		@SuppressWarnings("unchecked")
		List<ClassMap> data=query.list();
		System.out.println("got class by classid");
		return data;
	}	
	

	public List<ClassMap> getClassMapbyUsername(String username) {
		Session session=sessionFactory.openSession();
		String hql="from ClassMap as a where a.username=:username";
		Query query=session.createQuery(hql);
		query.setString("username", username);
		@SuppressWarnings("unchecked")
		List<ClassMap> data=query.list();
		System.out.println("got class by username");
		return data;
	}	

	
}
