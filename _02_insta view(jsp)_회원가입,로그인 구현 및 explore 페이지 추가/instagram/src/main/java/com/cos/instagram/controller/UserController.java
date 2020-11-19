package com.cos.instagram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.instagram.model.User;
import com.cos.instagram.repository.UserRepository;

@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository mUserRepository;
	
	// 로그인 창으로
	@GetMapping("auth/login")
	public String authLogin() {
		return "auth/login";
	}
	
	//회원가입 창으로
	@GetMapping("auth/join")
	public String authJoin() {
		return "auth/join";
	}
	
	// 회원가입 join.jsp 에서 form action = /auth/joinProc 타고 넘어온다.
	@PostMapping("/auth/joinProc")
	public String authJoinProc(User user) {
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		user.setPassword(encPassword);
		log.info("rawPassword : "+rawPassword);
		log.info("encPassword : "+encPassword);
		
		mUserRepository.save(user);
		
		return "redirect:/auth/login";
		
	}
	

}
