package com.cos.instagram.repository;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.instagram.model.Follow;

public interface FollowRepository extends JpaRepository<Follow, Integer> {
	
	//unFollow
	@Transactional
	int deleteByFromUserIdAndToUserId(int fromUserId, int toUserId);
	
	//팔로우 유무
	int countByFromUserIdAndToUserId(int fromUserId, int toUserId);

}
