package com.callor.hello.service.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

@Service("authorProviderImpl")
public class AuthorProviderImpl implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String u_name = authentication.getName();
		String u_password = authentication.getCredentials().toString();
		// Key, Value
		Map<String, String> user = new HashMap<>();
		// addattribute 와 비슷함
		user.put("username", u_name);
		user.put("email", "callor@callor.com");
		
		List<GrantedAuthority> grantList = new ArrayList<>();
		// 한 사람에게 복수의 권한을 줌
		grantList.add(new SimpleGrantedAuthority("ADMIN"));
		grantList.add(new SimpleGrantedAuthority("USER"));
		
		UsernamePasswordAuthenticationToken token
		= new UsernamePasswordAuthenticationToken(user, u_password, grantList);
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true; // << true로 만들어줘야지 작동함
	}
	

}
