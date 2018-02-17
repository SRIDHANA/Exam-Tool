package com.sridhana.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.sridhana.model.User;


public class UserDAO {


	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public final String  stringAdmin = "ADMIN";
	public final String  stringStudent = "STUDENT";
	public final String  stringFaculty = "FACULTY";
	
// Autowiring declarations above -actual code starts here

//general get Operation for all users
	@SuppressWarnings("unchecked")
	public User getUser(String Username) {
		Session session=sessionFactory.openSession();
		String hql="from User as a where a.username=:username";
			Query query=session.createQuery(hql);
			query.setString("username", Username);
		User user =	(User)query.uniqueResult();
			//List<User> data=query.list();
		System.out.println("got user by username");
		return user;
	}
	
	
// Admin CRUD operations	
	public void addAdmin(User admin ) {
		admin.setUsertype(stringAdmin);
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(admin);
		System.out.println("Added admin");
	}

	public void updateAdmin(User admin) {
		admin.setUsertype(stringAdmin);
		Session session = this.sessionFactory.getCurrentSession();
		session.update(admin);
		System.out.println("Updated admin");
	}

	@SuppressWarnings("unchecked")
	public List<User> listAdmin() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql="from User as a where a.usertype=:usertype";
		Query query=session.createQuery(hql);
		query.setString("usertype", stringAdmin );
		List<User> data=query.list();
		// String employeeName = session.createQuery("select empMaster.name from EmployeeMaster empMaster where empMaster.id = :id").setInteger("id",10).uniqueResult();
		System.out.println("Listed admin");		
		return data;
	}
		
	public void deleteAdmin(User admin) {
	 	admin.setUsertype(stringAdmin);
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(admin);
		tx.commit();
		session.close();
		System.out.println("Deleted admin");
	}		
	
	
// Faculty CRUD operations	

	public void addFaculty(User faculty ) {
		faculty.setUsertype(stringFaculty);
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(faculty);
		System.out.println("Added faculty");
	}

	public void updateFaculty(User faculty) {
		faculty.setUsertype(stringFaculty);
		Session session = this.sessionFactory.getCurrentSession();
		session.update(faculty);
		System.out.println("Updated faculty");
	}

	@SuppressWarnings("unchecked")
	public List<String> listallFacultyUsernames() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql="select username from User as a where a.usertype=:usertype";
		Query query=session.createQuery(hql);
		query.setString("usertype", stringFaculty );
		List<String> data=query.list();
		System.out.println("Listed Faculty");		
		return data;
	}
		
	@SuppressWarnings("unchecked")
	public List<User> listFaculty() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql="from User as a where a.usertype=:usertype";
		Query query=session.createQuery(hql);
		query.setString("usertype", stringFaculty );
		List<User> data=query.list();
		System.out.println("Listed Faculty");		
		return data;
	}
	
	public void deleteFaculty(User faculty) {
		faculty.setUsertype(stringFaculty);
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(faculty);
		tx.commit();
		session.close();
		System.out.println("Deleted faculty");
	}
		


//Student CRUD operations

	public void addStudent(User student ) {
		student.setUsertype(stringStudent);
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(student);
		System.out.println("Added student");
	}

	public void updateStudent(User student) {
		student.setUsertype(stringStudent);
		Session session = this.sessionFactory.getCurrentSession();
		session.update(student);
		System.out.println("Updated student");
	}

	@SuppressWarnings("unchecked")
	public List<User> listStudent() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql="from User as a where a.usertype=:usertype";
		Query query=session.createQuery(hql);
		query.setString("usertype", stringStudent );
		List<User> data=query.list();
		System.out.println("Listed student");		
		return data;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> listStudentUsernames() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql="from User as a where a.usertype=:usertype";
		Query query=session.createQuery(hql);
		query.setString("usertype", stringStudent );
		List<String> data=query.list();
		System.out.println("Listed Faculty");		
		return data;
	}
		
	public void deleteStudent(User student) {
		student.setUsertype(stringStudent);
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(student);
		tx.commit();
		session.close();
		System.out.println("Deleted student");
	}

	
			
//	public List<User> getStudent(String Username) {
//		Session session=sessionFactory.openSession();
//		String hql="from User as a where a.username=:username and a.usertype=:Usertype";
//		Query query=session.createQuery(hql);888888888888888
//		query.setString("username", Username);
//		@SuppressWarnings("unchecked")
//		List<User> data=query.list();
//		System.out.println("got student by username");
//		return data;
//	}
	
}
