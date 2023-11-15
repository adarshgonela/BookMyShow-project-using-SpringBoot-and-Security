package com.adarsh.BookMyShowProject.UserConfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.adarsh.BookMyShowProject.Repository.UserInfoRepository;
import com.adarsh.BookMyShowProject.entity.User;

public class UserNameException implements UserDetailsService {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> optionalUser = userInfoRepository.findByName(username);
		if (optionalUser.isPresent()) {
			return new Mapping_ByNew_Variable(optionalUser.get());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}

	}

}
