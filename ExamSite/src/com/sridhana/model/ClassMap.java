package com.sridhana.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ClassMap")
public class ClassMap implements Serializable{

	
	@Id
	@Column(name = "classid")
	private String classid;
	private String username;
	
	public ClassMap()
	{}
	public ClassMap(String classid,  String username) {
		super();
		this.classid = classid;
		this.username = username;
	}
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
		
}
