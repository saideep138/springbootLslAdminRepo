package com.lsl.zpackageoftsal.zconcepts.jpa;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Table(name="student")
@Entity
public class Student {

	@Column(name="studentname")
	String studentname;
	
	@Id
	@Column(name="sid")
	Long sid;
	
//    @ManyToMany(mappedBy = "roles")
//    private Collection<CourseStudent> users;
	
	@ManyToMany 
    @JoinTable( 
        name = "student", 
        joinColumns = @JoinColumn(
          name = "sid", referencedColumnName = "sid")
        ,
        inverseJoinColumns = @JoinColumn(
                name = "nsid", referencedColumnName = "sid")
        ) 
    private Collection<CourseStudent> courses;

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public Collection<CourseStudent> getCourses() {
		return courses;
	}

	public void setCourses(Collection<CourseStudent> courses) {
		this.courses = courses;
	}
	
	
}
