package com.sridhana.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exam_details")
public class Exam_Details {
	
	@Id
	@Column(name = "examid")
	private String examid;
	private String examname;
	private String classid;
	private int timelimit;
	private Timestamp creation_date;
	private Timestamp last_updated_date;
	public Exam_Details()
	{}
	public Exam_Details(String examid, String examname, String classid, int timelimit, Timestamp creation_date,
			Timestamp last_updated_date) {
		super();
		this.examid = examid;
		this.examname = examname;
		this.classid = classid;
		this.timelimit = timelimit;
		this.creation_date = creation_date;
		this.last_updated_date = last_updated_date;
	}
	public String getExamid() {
		return examid;
	}
	public void setExamid(String examid) {
		this.examid = examid;
	}
	public String getExamname() {
		return examname;
	}
	public void setExamname(String examname) {
		this.examname = examname;
	}
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public int getTimelimit() {
		return timelimit;
	}
	public void setTimelimit(int timelimit) {
		this.timelimit = timelimit;
	}
	public Timestamp getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Timestamp creation_date) {
		this.creation_date = creation_date;
	}
	public Timestamp getLast_updated_date() {
		return last_updated_date;
	}
	public void setLast_updated_date(Timestamp last_updated_date) {
		this.last_updated_date = last_updated_date;
	}


	
}
