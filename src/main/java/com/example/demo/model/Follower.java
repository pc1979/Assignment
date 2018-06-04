package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Follower {
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne
	private Person person;
	
	@OneToOne
	private Person follower_person;
	

	public Person getFollower_person() {
		return follower_person;
	}

	public void setFollower_person(Person follower_person) {
		this.follower_person = follower_person;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Follower [id=" + id + ", person=" + person + ", follower_person=" + follower_person + "]";
	}

	
}
