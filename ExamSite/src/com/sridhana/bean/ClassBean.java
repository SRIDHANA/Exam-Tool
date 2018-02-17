package com.sridhana.bean;

public class ClassBean {

	private String classid;
	private String courseid;
	private String coursename;
	private String facultyusername;
	private String firstname;
	private String lastname;
	
	public ClassBean()
	{}

	public ClassBean(String classid, String courseid, String coursename, String facultyusername, String firstname,
			String lastname) {
		super();
		this.classid = classid;
		this.courseid = courseid;
		this.coursename = coursename;
		this.facultyusername = facultyusername;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getFacultyusername() {
		return facultyusername;
	}

	public void setFacultyusername(String facultyusername) {
		this.facultyusername = facultyusername;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
