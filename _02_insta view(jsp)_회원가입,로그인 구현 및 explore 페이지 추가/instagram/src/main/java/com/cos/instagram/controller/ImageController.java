package com.cos.instagram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.instagram.service.MyUserDetail;

@Controller
public class ImageController {
	
	
	private static final Logger log = LoggerFactory.getLogger(ImageController.class);

	// 로그인, 로그인하면 feed.jsp로 넘어간다.
	@GetMapping("/image/feed")
	public String imageFeed(@AuthenticationPrincipal MyUserDetail userDetail) {
		
		log.info("username : "+userDetail.getUsername());
		return "image/feed";
	}

}
