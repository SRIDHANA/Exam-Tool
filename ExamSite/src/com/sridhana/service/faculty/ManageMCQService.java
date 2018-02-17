package com.sridhana.service.faculty;

import org.springframework.stereotype.Service;

import com.sridhana.DAO.McqDAO;

import com.sridhana.model.Mcq;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
@Service
@Transactional
public class ManageMCQService {

	@Autowired
	private McqDAO mcqDAO;	

	@Autowired
	@Qualifier(value = "mcqDAO")
	public void setMcqDAO(McqDAO mcqDAO) {
		this.mcqDAO = mcqDAO;
	}

	// Autowiring declarations above -actual code starts from here
	public void addMcq(Mcq mcq) {
		mcqDAO.addMcq(mcq);
	}

	public void updateMcq(Mcq mcq) {
		mcqDAO.updateMcq(mcq);
	}

	public List<Mcq> listMcq() {
		return mcqDAO.listMcq();
	}
	
	public List<Mcq> listMcqbyExamid(String examid) {
	  return mcqDAO.listMcqbyExamid(examid);
	}
	
	
	public void deleteMcq(Mcq mcq) {
		mcqDAO.deleteMcq(mcq);
	
	}
	

	
}
