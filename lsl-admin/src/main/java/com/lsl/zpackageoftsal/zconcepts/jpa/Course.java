package com.lsl.zpackageoftsal.zconcepts.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="course")
@Entity
public class Course {
	
	@Column(name="coursename")
	String coursename;
	
	@Id
	@Column(name="cid")
	Long cid;
}
