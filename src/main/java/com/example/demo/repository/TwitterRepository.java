package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Follower;
import com.example.demo.model.Person;



public interface TwitterRepository extends JpaRepository<Follower, Integer>{

	
		    
	 @Query(value="SELECT p.id from Person p,Follower f where  p.id = f.follower_person_id and f.person_id= :currentUserId",nativeQuery=true	) 
	 public List<Integer> findfollowers(@Param("currentUserId") int currentUserId);
	 
	 @Query(value="SELECT content FROM messages WHERE personid_id IN (:currentuserId)",nativeQuery=true	) 
	 public List<String> findUserMessage(@Param("currentuserId") List currentuserId);
	 
	 @Query(value="SELECT p.id from Person p, Follower f where p.id = f.person_id and f.follower_person_id = :currentuserId",nativeQuery=true	) 
	 public List<Integer> findUserFollowing(@Param("currentuserId") int currentuserId);
	 
	 @Query(value="SELECT f.id from follower f where f.person_id = :userId and f.follower_person_id = :currentuserId",nativeQuery=true	) 
	 public Integer followUser(@Param("userId") int userId, @Param("currentuserId") int currentuserId);
	 
	 @Modifying
	 @Transactional
	 @Query(value="INSERT INTO follower (person_id, follower_person_id) VALUES (:currentuserId, :userId)",nativeQuery=true	) 
	 public List<Integer> insertfollowUser(@Param("userId") int followid, @Param("currentuserId") int currentuserId);

	 @Modifying
	 @Transactional
	 @Query(value="DELETE FROM follower f where f.id=:followid",nativeQuery=true	) 
	 public void deleteUser(@Param("followid") int followid);
	
	 
	 @Query(value="SELECT id from people where passwd =:handle",nativeQuery=true	) 
	 public int getId(@Param("handle") String handle);
	 
	 @Query(value="SELECT f2.person_id,(SELECT f1.follower_person_id FROM follower f1 WHERE f1.person_id=f2.person_id GROUP BY f1.follower_person_id ORDER BY COUNT(f1.follower_person_id) DESC LIMIT 1) AS follower_person_id FROM follower f2 GROUP BY f2.person_id",nativeQuery=true)
	 public List<Object> popularUser();
}
