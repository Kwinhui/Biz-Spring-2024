package com.callor.gallery.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/*
 * @Configuration
 * 지금부터 이 클래스는 ContextBeanConfig 설정을 하는 클래스다 라는 선언
 */

@Configuration
public class RootContextConfig {
	
	// Bean의 이름을 multipartResolver 로 쓰겠다
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getFileResolver() throws IOException{
		
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		
		// 한개의 파일 용량 제한하기
		resolver.setMaxUploadSizePerFile(1024 * 1024 * 2);	// 2MB
		// 전체 사이즈
		resolver.setMaxUploadSize(1024 * 1024 * 20);	// 20MB
		// 임시 폴더
		resolver.setUploadTempDir(new FileSystemResource("c:/temp"));
		// 한글 깨짐 방지
		resolver.setDefaultEncoding("UTF-8");
		
		
		return resolver;
	}

	// name = "upLoadPath" - fileServiceImplV1 에 있는 이름과 똑같이 만들어야함
	@Bean(name ="upLoadPath")
	public String upLoadPath() {
		
		return "c:/app/upload";
	}
	
}
