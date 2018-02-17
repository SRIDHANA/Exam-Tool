package com.sridhana.model;
import com.sridhana.model.Course;
import com.sridhana.model.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Clas")
public class Clas {

	
	private String classid;
	private Course course;
	private User user;
	
	public Clas()
	{}

	public Clas(String classid, Course course, User user) {
		super();
		this.classid = classid;
		this.course = course;
		this.user = user;
	}
	@Id
	@Column(name = "classid")
	public String getClassid() {
		return classid;
	}

	
	public void setClassid(String classid) {
		this.classid = classid;
	}

	@JoinColumn(name="courseid")
	@ManyToOne(fetch=FetchType.EAGER)
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	
	@JoinColumn(name="facultyusername")
	@ManyToOne(fetch=FetchType.EAGER)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
