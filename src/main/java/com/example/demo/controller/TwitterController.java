package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Follower;
import com.example.demo.model.Person;
import com.example.demo.repository.TwitterRepository;
@RestController

public class TwitterController {
	
	private TwitterRepository twitterRepository;
	
	@Autowired
	public void setTwitterRepository(TwitterRepository twitterRepository) {
		this.twitterRepository = twitterRepository;
	}
	
	@GetMapping(path="/userfollowers")
	public List<Integer> getfollowers() {
		System.out.println("currentUser:::"+currentUser());
		
		return twitterRepository.findfollowers(currentUser());
		
	}
	
	@GetMapping(path="/messages")
	public List<String> getAllUserMessages() {
		 List<Integer> followersId = getfollowers();
		 followersId.add((currentUser()));
	        
		return twitterRepository.findUserMessage(followersId);
		
	}
	
	@GetMapping(path="/userfollowing")
	public List<Integer> getAllUserisFollowing(){
		return twitterRepository.findUserFollowing(currentUser());
		}
	
	@GetMapping(path="/follow/{id}")
	public void followUser(@PathVariable int id  ){
		
		//int id=getfollowId(handle);
		
		
		Person person =new Person();
		person.setId(id);
		
		Person person1 =new Person();
		person1.setId(currentUser());
		
		Follower follower= new Follower();
		follower.setPerson(person);
		follower.setFollower_person(person1);
		
		twitterRepository.save(follower);
		
	    
		}
	
	@GetMapping(path="/unfollow/{id}")
	public void unfollowUser(@PathVariable int id ){
		//int id=getfollowId(handle);
		System.out.println("id to unfollow:::"+id);
		System.out.println("currentUser():::"+currentUser());
	    int followid=twitterRepository.followUser(id,currentUser());
	    System.out.println("id to delete:::"+followid);
	    twitterRepository.deleteUser(followid);
	    //twitterRepository.delete(followid);
	    System.out.println("Unfollowed successfully");
		}
	
	
	@GetMapping(path="/popular")
	private List<Object> getpopularUser() {
		return twitterRepository.popularUser();
       
    }
	
	private int getfollowId(String handle) {
		return twitterRepository.getId(handle);
       
    }

	private int currentUser() {
		//return "4";
        return Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
    }

}
