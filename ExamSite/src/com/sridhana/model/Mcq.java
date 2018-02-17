package com.sridhana.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Mcq")
public class Mcq implements Serializable {

	@Id
	@Column(name = "mcqquestionid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mcqquestionid;
	
	@Id
	@Column(name = "examid")
	private String examid;
	private String question;
	private String optiona;
	private String optionb;
	private String optionc;
	private String optiond;
	private String optione;
	private String optionf;
	private String answer;
	private int marks_alloted;
	
	public Mcq(){}

	
	public Mcq(int mcqquestionid, String examid, String question, String optiona, String optionb, String optionc,
			String optiond, String optione, String optionf, String answer, int marks_alloted) {
		super();
		this.mcqquestionid = mcqquestionid;
		this.examid = examid;
		this.question = question;
		this.optiona = optiona;
		this.optionb = optionb;
		this.optionc = optionc;
		this.optiond = optiond;
		this.optione = optione;
		this.optionf = optionf;
		this.answer = answer;
		this.marks_alloted = marks_alloted;
	}


	public int getMcqquestionid() {
		return mcqquestionid;
	}

	public void setMcqquestionid(int mcqquestionid) {
		this.mcqquestionid = mcqquestionid;
	}

	public String getExamid() {
		return examid;
	}

	public void setExamid(String examid) {
		this.examid = examid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptiona() {
		return optiona;
	}

	public void setOptiona(String optiona) {
		this.optiona = optiona;
	}

	public String getOptionb() {
		return optionb;
	}

	public void setOptionb(String optionb) {
		this.optionb = optionb;
	}

	public String getOptionc() {
		return optionc;
	}

	public void setOptionc(String optionc) {
		this.optionc = optionc;
	}

	public String getOptiond() {
		return optiond;
	}

	public void setOptiond(String optiond) {
		this.optiond = optiond;
	}

	public String getOptione() {
		return optione;
	}

	public void setOptione(String optione) {
		this.optione = optione;
	}

	public String getOptionf() {
		return optionf;
	}

	public void setOptionf(String optionf) {
		this.optionf = optionf;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getMarks_alloted() {
		return marks_alloted;
	}

	public void setMarks_alloted(int marks_alloted) {
		this.marks_alloted = marks_alloted;
	}
	
}
