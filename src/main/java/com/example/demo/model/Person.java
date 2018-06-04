package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue

	private int id;
	
	private String name;
	private String passwd;
	@OneToOne(mappedBy="person", cascade = CascadeType.ALL)
	private Follower follower;
	
	@OneToOne(mappedBy="person", cascade = CascadeType.ALL)
	private Follower follower_person;
	
	@OneToOne(mappedBy="person", cascade = CascadeType.ALL)
	private Follower messages;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Follower getFollower() {
		return follower;
	}
	public void setFollower(Follower follower) {
		this.follower = follower;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", passwd=" + passwd + ", follower=" + follower
				+ ", follower_person=" + follower_person + ", messages=" + messages + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	

}
