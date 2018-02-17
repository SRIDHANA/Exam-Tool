package com.sridhana.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.sridhana.DAO.ClassMapDAO;
import com.sridhana.model.ClassMap;

@Service
@Transactional
public class AssignClassService {

	@Autowired
	private ClassMapDAO classMapDAO;	

	@Autowired
	@Qualifier(value = "classMapDAO")
	public void setClassMapDAO(ClassMapDAO classMapDAO) {
		this.classMapDAO = classMapDAO;
	}

	// Autowiring declarations above -actual code starts from here
	public void addClassMap(ClassMap classMap) {
		classMapDAO.addClassMap(classMap);
	}

	public void updateClassMap(ClassMap classMap) {
		classMapDAO.updateClassMap(classMap);
	}


	public List<ClassMap> listClassMap() {
		return classMapDAO.listClassMap();
	}
	
	public void deleteClassMap(ClassMap classMap) {
		classMapDAO.deleteClassMap(classMap);
	
	}
	
	public List<ClassMap> getClassMapbyclassid(String classid) {
		return classMapDAO.getClassMapbyclassid(classid);
		
	}
	
	public List<ClassMap> getClassMapbyUsername(String username) {
		return classMapDAO.getClassMapbyUsername(username);
		
	}	
}
