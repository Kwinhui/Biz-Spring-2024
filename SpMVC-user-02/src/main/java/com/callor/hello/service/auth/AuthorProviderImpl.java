package com.callor.hello.service.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.tagext.ValidationMessage;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("authorProviderImpl")
public class AuthorProviderImpl implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String u_name = authentication.getName();
		String u_password = authentication.getCredentials().toString();

		// 로그인한 사용자 id(u_name) 을 검사하여
		// 허가받은 사용자인가 확인하고 아니면 exception 을 발생하여
		// 알려주기
		if (u_name == null || u_name.isBlank() || !u_name.equalsIgnoreCase("callor")) {
			throw new UsernameNotFoundException("USERNAME 없음");
		}
		if (u_password == null || u_password.isBlank() || !u_password.equals("12345")) {
			throw new BadCredentialsException("비밀번호가 틀렸습니다.");
		}

		// Key, Value
		Map<String, String> user = new HashMap<>();
		// addattribute 와 비슷함
		user.put("username", u_name);
		user.put("email", "callor@callor.com");

		List<GrantedAuthority> grantList = new ArrayList<>();
		// 한 사람에게 복수의 권한을 줌
//		grantList.add(new SimpleGrantedAuthority("ADMIN"));
		grantList.add(new SimpleGrantedAuthority("USER"));

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, u_password,
				grantList);
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true; // << true로 만들어줘야지 작동함
	}

}
