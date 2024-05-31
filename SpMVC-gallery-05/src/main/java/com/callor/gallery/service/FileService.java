package com.callor.gallery.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.models.ImagesVO;

public interface FileService {
	// 한개의 파일
	public String fileUp(MultipartFile file);
	
	// 여러개의 파일
	public List<ImagesVO> filesUp(MultipartHttpServletRequest files);

	public void fileDelete(String i_up_image);

	

	
	
}
