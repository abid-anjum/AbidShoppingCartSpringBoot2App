package com.abid.cart.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	//@Autowired
	//UserRepository userDetail;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//User appUser = userDetail.getByEmail(username);
	    List grantList = new ArrayList();
		UserDetails user = (UserDetails) new User("abid","123",grantList);
		return user;
	}
}
