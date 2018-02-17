package com.sridhana.service.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

import com.sridhana.DAO.UserDAO;
import com.sridhana.model.User;


@Service
@Transactional
public class ManageStudentService {

	@Autowired
	private UserDAO userDAO;	

	@Autowired
	@Qualifier(value = "userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	// Autowiring declarations above -actual code starts from here
	public void addStudent(User student) {
		userDAO.addStudent(student);
	}

	public void updateStudent(User student) {
		userDAO.updateStudent(student);
	}


	public List<User> listStudent() {
		return userDAO.listStudent();
	}
	
	public void deleteStudent(User student) {
		userDAO.deleteStudent(student);
	
	}
	
	public User getStudent(String Username) {
		return userDAO.getUser(Username);
		
	}
	
}
