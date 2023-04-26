package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepo userrepo;
	
	public UserPojo insert(UserPojo user) {
		return userrepo.save(user);
	}
	
	public List<UserPojo> viewall(){
		return userrepo.findAll();
	}
	
	public UserPojo viewbyid(int userid){
		return userrepo.findById(userid).get();
	}
	
	public UserPojo update(int userid,UserPojo newuser) {
		UserPojo olduser=userrepo.findById(userid).get();
		if(olduser!=null) {
		olduser.setUsername(newuser.getUsername());
		olduser.setPassword(newuser.getPassword());
		olduser.setCity(newuser.getCity());
		olduser.setLogin(newuser.getLogin());
		}
		return userrepo.save(olduser);
	}
	
	public UserPojo delete(int userid) {
		UserPojo user=new UserPojo();
		if(userrepo.findById(userid).isPresent()) {
			userrepo.deleteById(userid);
		}
		return user;
	}
	
	public UserPojo viewUsername(String Username) {
		return userrepo.findByusername(Username);
	}

}
 