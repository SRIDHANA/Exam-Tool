package com.sridhana.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.sridhana.DAO.UserDAO;
import com.sridhana.model.User;

@Service
@Transactional
public class LoginService {

	@Autowired
	private UserDAO userDAO;	

	@Autowired
	@Qualifier(value = "userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
		
	public User validateUser(User user) {  
		
		User returnuser = null;
		User userfound = userDAO.getUser(user.getUsername());
//		for(User userfound: userfoundlist)
//		{   
			if((userfound.getUsername().equals(user.getUsername())))
			{
				returnuser = userfound;	
			if((userfound.getPassword()).equals(user.getPassword()))
			{
				returnuser = userfound;	
				System.out.println("Found user" + userfound.getLastname() + userfound.getFirstname());
//				break;		
			}
			}
		
//		}	
		if ( returnuser == null)
		{
		 returnuser = new User();
		}
		return returnuser;
	}
}
