package com.app.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Students")
public class Student {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer admission_id;
	
	@Column
	private String name;
	@Column
	private String section;
	@Column
	private String address;
	//private Address address; I will create a HAS-A relation later
	
	
	
	public Student(Integer admission_id, String name, String section, String address) {
		super();
		this.admission_id = admission_id;
		this.name = name;
		this.section = section;
		this.address = address;
	}
	
	public Integer getAdmission_id() {
		return admission_id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [admission_id=" + admission_id + ", name=" + name + ", section=" + section + ", address="
				+ address + "]";
	}
	
	

}
