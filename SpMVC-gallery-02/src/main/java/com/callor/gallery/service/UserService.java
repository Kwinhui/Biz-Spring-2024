package com.callor.gallery.service;

import com.callor.gallery.models.UserVO;

public interface UserService {

	// 회원가입
	public int create_user(UserVO userVO);
	
	public void create_table();
}
