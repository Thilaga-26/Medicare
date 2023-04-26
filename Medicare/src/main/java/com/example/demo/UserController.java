package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/insert")
	public ResponseEntity<UserPojo> insert(@RequestBody UserPojo user) {
		return ResponseEntity.ok(userservice.insert(user));
	}
	
	@GetMapping("/viewall")
	public ResponseEntity<List<UserPojo>> viewall(){
		return ResponseEntity.ok(userservice.viewall());	
    }
	
	@GetMapping("/view/{username}")
	public ResponseEntity<UserPojo> viewuserbyname(@PathVariable String username){
		return ResponseEntity.ok(userservice.viewUsername(username));
	}
	
	@PutMapping("/update/{userid}")
	public ResponseEntity<UserPojo> update(@PathVariable int userid, @RequestBody UserPojo newuser) {
		return ResponseEntity.ok(userservice.update(userid,newuser));
	}
	
	@DeleteMapping("/delete/{userid}")
	public List<UserPojo> delete(@PathVariable int userid){
		ResponseEntity.ok(userservice.delete(userid));
		return userservice.viewall();
	}
	
}
