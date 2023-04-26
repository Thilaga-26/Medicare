package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<UserPojo, Integer> {
	
	@Query(value="select * from UserPojo where username=?",nativeQuery = true)
	public UserPojo findByusername(String username);

}
