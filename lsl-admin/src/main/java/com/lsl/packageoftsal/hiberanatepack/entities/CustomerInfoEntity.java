package com.lsl.packageoftsal.hiberanatepack.entities;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="customerinfo")
public class CustomerInfoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cusid")
	private long id;
	
	@Column(name="cus_name")
	private String customerName;
	
	@Column(name="age")
	private long age;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="mobileno")
	private String mobileNo;
	
//	@OneToMany(mappedBy="tripinfo")
//	private Collection<TripEntity> TripEntities;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public CustomerInfoEntity() {
		super();
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public CustomerInfoEntity( String customerName, long age, String gender, String mobileNo) {
		super();
		this.customerName = customerName;
		this.age = age;
		this.gender = gender;
		this.mobileNo = mobileNo;
	}

	
}
