package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Messages {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	public Person getPersonid() {
		return personid;
	}
	public void setPersonid(Person personid) {
		this.personid = personid;
	}
	@OneToOne
	private Person personid;
	
	
	private String content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
