package com.sridhana.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_mcq_answers")
public class Student_MCQ_Answers implements Serializable {

	@Id
	@Column(name = "examid")
	private String examid;

	@Id
	@Column(name = "student_username")
	private String student_username;

	@Id
	@Column(name = "mcqquestionid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mcqquestionid;	
	private String marked_answer;
	private int marks_alloted;
	private int marks_graded;
	public Student_MCQ_Answers()
	{}
	public Student_MCQ_Answers(String examid, String student_username, int mcqquestionid, String marked_answer,
			int marks_alloted, int marks_graded) {
		super();
		this.examid = examid;
		this.student_username = student_username;
		this.mcqquestionid = mcqquestionid;
		this.marked_answer = marked_answer;
		this.marks_alloted = marks_alloted;
		this.marks_graded = marks_graded;
	}
	public String getExamid() {
		return examid;
	}
	public void setExamid(String examid) {
		this.examid = examid;
	}
	public String getStudent_username() {
		return student_username;
	}
	public void setStudent_username(String student_username) {
		this.student_username = student_username;
	}
	public int getMcqquestionid() {
		return mcqquestionid;
	}
	public void setMcqquestionid(int mcqquestionid) {
		this.mcqquestionid = mcqquestionid;
	}
	public String getMarked_answer() {
		return marked_answer;
	}
	public void setMarked_answer(String marked_answer) {
		this.marked_answer = marked_answer;
	}
	public int getMarks_alloted() {
		return marks_alloted;
	}
	public void setMarks_alloted(int marks_alloted) {
		this.marks_alloted = marks_alloted;
	}
	public int getMarks_graded() {
		return marks_graded;
	}
	public void setMarks_graded(int marks_graded) {
		this.marks_graded = marks_graded;
	}
	
	
	
	
	
	
	
	
	
}
