package com.callor.gallery.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.gallery.dao.RoleDao;
import com.callor.gallery.dao.UserDao;
import com.callor.gallery.models.RoleVO;
import com.callor.gallery.models.UserVO;

import lombok.extern.slf4j.Slf4j;

/*
 * 생성자를 만들지않고 서비스 위에 @AllArgsConstructor 를 붙이는 경우도 있지만
 * 무한루프에 빠지게되는 버그가 있기때문에 사용하지 않는게 좋다.
 */
@Slf4j
@Service("authProviderImpl")
public class AuthProviderImpl implements AuthenticationProvider{

	private final PasswordEncoder passwordEncoder;
	private final UserDao userDao;
	private final RoleDao roleDao;

	public AuthProviderImpl(PasswordEncoder passwordEncoder, UserDao userDao, RoleDao roleDao) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.userDao = userDao;
		this.roleDao = roleDao;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		log.debug("USERNAME {}, PASSWORD {}", username, password);
		if(username == null || username.isBlank()) {
			throw new UsernameNotFoundException("사용자이름을 입력하세요");
		}
		
		// DB 에 없는 username 검사
		UserVO userVO = userDao.findById(username);
		if(userVO == null || !userVO.getUsername().equals(username)) {
			throw new UsernameNotFoundException("없는 사용자이름 입니다");
		}
		
		if(password == null || password.isBlank()) {
			throw new BadCredentialsException("비밀번호를 입력하세요 ");
		}
		

		if(!passwordEncoder.matches(password, userVO.getPassword())) {
			throw new BadCredentialsException("비밀번호가 잘못되었음");
		}
		
		List<GrantedAuthority> grantList = new ArrayList<>();
		List<RoleVO> roles = roleDao.findByUsername(username);
		for(RoleVO vo : roles) {
			grantList.add(new SimpleGrantedAuthority(vo.getR_role()));
		}
		
	
//		grantList.add(new SimpleGrantedAuthority("USER"));
//		grantList.add(new SimpleGrantedAuthority("ADMIN"));
		
		UsernamePasswordAuthenticationToken token
			= new UsernamePasswordAuthenticationToken(userVO, password, grantList);
		
		
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
