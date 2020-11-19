package com.cos.instagram.repository;

import java.util.List;

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
	
	// 팔로우 리스트 (하얀 버튼)
	List<Follow> findByFromUserId(int fromUserId);
	
	// 팔로우 리스트(맞팔 체크 후 버튼 샐깔 결정
	List<Follow> findByToUserId(int toUserId);
}
