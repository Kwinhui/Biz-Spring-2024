package com.callor.gallery.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/*
 * fileupload 에선 try-catch 를 사용하지않고
 * 오류가 발생하면 오류나기 전으로 다시 return
 */

public interface FileUploadService {
	/*
	 * 파일객체 1개를 전달받아  
	 * 해킹에 대비하여 파일 이름을 변형하고  
	 * 변형된 이름으로 서버의 폴더에 업로드 하고
	 * 변형된 이름을 return 하는 일을 수행
	 */
	public String fileUpload(MultipartFile file) throws Exception;
	 
	// 여러개의 파일을 업로드 실행하고 변형된 파일 이름 리스트를 return
	public List<String> filesUpload(MultipartHttpServletRequest files) throws Exception;
	
}
