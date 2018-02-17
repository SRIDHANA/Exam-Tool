package com.sridhana.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sridhana.model.Course;

@Repository
public class CourseDAO {

	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	
	// Autowiring declarations above -actual code starts here
	public void addCourse(Course course ) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(course);
		System.out.println("Added Course");		
	}

	public void updateCourse(Course course) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(course);
		System.out.println("Updated Course");		

	}

	@SuppressWarnings("unchecked")
	public List<Course> listCourse() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Course> CourseList = session.createQuery("from Course").list();
		System.out.println("Listed course");		
		return CourseList;
	}
		
	public void deleteCourse(Course course) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(course);
		tx.commit();
		session.close();
		System.out.println("Deleted course");
	}
		
	@SuppressWarnings("unchecked")
	public List<String> listallCourseIds() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql="select courseid from course ";
		Query query=session.createQuery(hql);
		List<String> data=query.list();
		System.out.println("Listed courseid's");		
		return data;
	}
	
	public List<Course> getCourse(String courseid) {
		Session session=sessionFactory.openSession();
		String hql="from Course as a where a.courseid=:courseid";
		Query query=session.createQuery(hql);
		query.setString("courseid", courseid);
		@SuppressWarnings("unchecked")
		List<Course> data=query.list();
		System.out.println("got class by courseid");
		return data;
	}	
	
	
}
