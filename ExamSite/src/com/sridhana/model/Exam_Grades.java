package com.sridhana.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.sql.Timestamp; 

@Entity
@Table(name = "exam_grades")
public class Exam_Grades implements Serializable{
	@Id
	@Column(name = "examid")
	private String examid;
	
	@Id
	@Column(name = "studentusername")
	private String studentusername;
	private String classid;
	private Timestamp written_date;
	private String status;
	private int  totalmarksalloted;
	private int  totalmarksgraded;
	private String grade;

	public Exam_Grades()
	{}

	public Exam_Grades(String examid, String studentusername, String classid, Timestamp written_date, String status, int totalmarksalloted, int totalmarksgraded, String grade) {
		super();
		this.examid = examid;
		this.studentusername = studentusername;
		this.classid = classid;
		this.written_date = written_date;
		this.status = status;
		this.totalmarksalloted = totalmarksalloted;
		this.totalmarksgraded = totalmarksgraded;
		this.grade = grade;
	}

	public String getExamid() {
		return examid;
	}

	public void setExamid(String examid) {
		this.examid = examid;
	}

	public String getStudentusername() {
		return studentusername;
	}

	public void setStudentusername(String studentusername) {
		this.studentusername = studentusername;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public Timestamp getWritten_date() {
		return written_date;
	}

	public void setWritten_date(Timestamp written_date) {
		this.written_date = written_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalmarksalloted() {
		return totalmarksalloted;
	}

	public void setTotalmarksalloted(int totalmarksalloted) {
		this.totalmarksalloted = totalmarksalloted;
	}

	public int getTotalmarksgraded() {
		return totalmarksgraded;
	}

	public void setTotalmarksgraded(int totalmarksgraded) {
		this.totalmarksgraded = totalmarksgraded;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
