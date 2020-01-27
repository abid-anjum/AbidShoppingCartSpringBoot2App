package com.abid.cart.web.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abid.cart.domain.model.security.Role;
import com.abid.cart.domain.model.security.User;
import com.abid.cart.domain.repository.UserRepository;

@Service
public class UserDetailsDBService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsDBService.class);

	@Autowired
	UserRepository userRepository;

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User dbuser = userRepository.getByEmail(username);
		
		if (dbuser == null)
			throw new UsernameNotFoundException(username);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		for (Role role : dbuser.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		return new org.springframework.security.core.userdetails.User(dbuser.getEmail(), dbuser.getPassword(),
				grantedAuthorities);
	}
}
