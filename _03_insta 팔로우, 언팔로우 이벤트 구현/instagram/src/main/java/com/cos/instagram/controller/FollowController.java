package com.cos.instagram.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.instagram.model.Follow;
import com.cos.instagram.model.User;
import com.cos.instagram.repository.FollowRepository;
import com.cos.instagram.repository.UserRepository;
import com.cos.instagram.service.MyUserDetail;

@Controller
public class FollowController {
	
	@Autowired
	private UserRepository mUserRepository;
	
	@Autowired
	private FollowRepository mFollowRepository;
	
	//팔로우
	@PostMapping("/follow/{id}")
	public @ResponseBody String follow
	(@AuthenticationPrincipal MyUserDetail userDetail,
	 @PathVariable int id) {
		
		User fromUser = userDetail.getUser();
		Optional<User> oToUser = mUserRepository.findById(id);
		User toUSer = oToUser.get();
		
		Follow follow = new Follow();
		follow.setFromUser(fromUser);
		follow.setToUser(toUSer);
		
		mFollowRepository.save(follow);
		
		return "ok";
	}
	
	//언팔로우
	// 팔로우를 취소하면 삭제한다.
	@DeleteMapping("/follow/{id}")
	public @ResponseBody String unFollow(@AuthenticationPrincipal MyUserDetail userDetail,
										 @PathVariable int id) {
		User fromUser = userDetail.getUser();
		Optional<User> oToUser = mUserRepository.findById(id);
		User toUser = oToUser.get();
		
		 mFollowRepository.deleteByFromUserIdAndToUserId(fromUser.getId(), toUser.getId());
		
		List<Follow> follows = mFollowRepository.findAll();
		return "ok";
	}
	
	//팔로워 리스트 
	@GetMapping("/follow/follower/{id}")
	public String followFollower(@PathVariable int id) {
		
		return "follow/follow";
	}
	
	//팔로우 리스트 
	@GetMapping("/follow/follow/{id}")
	public String followFollow(@PathVariable int id) {
		
		return "follow/follow";
	}
	

}
