package com.callor.gallery.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * web.xml 의 설정을 대신할 클래스 파일
 */
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// RootContextConfig.class 파일자체를 가져와 Class에 담아라 
		return new Class[]{RootContextConfig.class, MyBatisContextConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletContextConfig.class};
	}

	// "/" 로 요청이 들어오면 내가 다 받을게
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

	// web.xml 에선 Filter 가 상단에 있어야했지만 여기선 상관x 
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encKor = new CharacterEncodingFilter();
		encKor.setEncoding("UTF-8");
		encKor.setForceEncoding(true);
		
		return new Filter[] {encKor};
	}
	
	
	
	
	
	
	
	
	
	
	

}
