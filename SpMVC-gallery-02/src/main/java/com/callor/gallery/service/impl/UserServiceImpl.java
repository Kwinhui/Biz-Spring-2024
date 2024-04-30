package com.callor.gallery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.gallery.dao.RoleDao;
import com.callor.gallery.dao.UserDao;
import com.callor.gallery.models.UserVO;
import com.callor.gallery.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	// 제어의 역전, 의존관계 역전
	private final UserDao userDao;
	private final RoleDao roleDao;
	public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
		super();
		this.userDao = userDao;
		this.roleDao = roleDao;
	}

	@Override
	public int create_user(UserVO userVO) {
		
		return 0;
	}


	@Autowired	// 자동 실행
	@Override
	public void create_table() {
		// oracle 코드
		/*
		try {
			userDao.create_table(null);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			roleDao.create_table(null);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		*/
		userDao.create_table(null);
		roleDao.create_table(null);
		
	}
}
