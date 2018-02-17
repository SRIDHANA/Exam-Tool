package com.sridhana.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sridhana.DAO.UserDAO;
import com.sridhana.model.User;

import java.util.List;

import javax.transaction.Transactional;



@Service
@Transactional
public class ManageFacultyService {

	@Autowired
	private UserDAO userDAO;	

	@Autowired
	@Qualifier(value = "userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	// Autowiring declarations above -actual code starts from here
	public void addFaculty(User faculty) {
		userDAO.addFaculty(faculty);
	}

	public void updateFaculty(User faculty) {
		userDAO.updateFaculty(faculty);
	}


	public List<User> listFaculty() {
		return userDAO.listFaculty();
	}
	
	
	public void deleteFaculty(User faculty) {
		userDAO.deleteFaculty(faculty);
	
	}
	
	
//	public List<User> getFaculty(String Username) {
//		return userDAO.getFaculty(Username);
//		
//	}
	
}
