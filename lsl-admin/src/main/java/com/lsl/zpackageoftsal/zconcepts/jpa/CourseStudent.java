package com.lsl.zpackageoftsal.zconcepts.jpa;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Table(name="coursestudent")
@Entity
public class CourseStudent {
	
	
	@Column(name="cid")
	Long cid;

	@Id
	@Column(name="sid")
	Long sid;
	
	@Id
	@Column(name="csid")
	Long csid;
	
	@ManyToMany(mappedBy = "courses")
    private Collection<Student> roles;

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public Long getCsid() {
		return csid;
	}

	public void setCsid(Long csid) {
		this.csid = csid;
	}

	public Collection<Student> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Student> roles) {
		this.roles = roles;
	}
	
}
