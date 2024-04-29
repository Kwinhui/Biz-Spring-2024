package com.callor.gallery.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.dao.GalleryDao;
import com.callor.gallery.dao.ImageDao;
import com.callor.gallery.models.GalleryVO;
import com.callor.gallery.models.ImageVO;
import com.callor.gallery.service.FileUploadService;
import com.callor.gallery.service.GalleryService;

@Service
public class GalleryServiceImpl implements GalleryService{
	
	private final GalleryDao galleryDao;
	private final FileUploadService fileUploadService;
	private final ImageDao imagesDao;

	public GalleryServiceImpl(GalleryDao galleryDao, FileUploadService fileUploadService, ImageDao imagesDao) {
		super();
		this.galleryDao = galleryDao;
		this.fileUploadService = fileUploadService;
		this.imagesDao = imagesDao;
	}

	@Autowired
	public void create_table() {
		galleryDao.create_table(null);
		imagesDao.create_table("");
	}

	@Override
	public List<GalleryVO> selectAll() {
		
		return galleryDao.selectAll();
	}

	/*
	 * Single 파일을 업로드 했을때 사용하는 method
	 */
	
	@Override
	public GalleryVO createGallery(GalleryVO galleryVO, MultipartFile image_file) throws Exception {
		// Exception 이 발생하면 controller 로 보내
		
		
		
		galleryVO.setG_origin_image(image_file.getOriginalFilename());
		
		// 파일을 업로드 하고 return 받은 변형된 이름을 VO 에 setting
		String fileName = fileUploadService.fileUpload(image_file);
		galleryVO.setG_up_image(fileName);
		
		// id, 날짜, 시간, setting 대신 실행하기
		setGalleryOptions(galleryVO);
		
		int ret = galleryDao.insert(galleryVO);
		if(ret > 0) {
			return galleryVO;
		}
		
		return null;
	}

	/*
	 * MultiFile 을 업로드 했을때 사용할 method
	 */
	
	@Transactional
	@Override
	public List<GalleryVO> createGallery(GalleryVO galleryVO, MultipartHttpServletRequest image_files)
			throws Exception {
		// gallery insert 후 file 업로드
//		String i_gid = UUID.randomUUID().toString();
//		galleryVO.setG_id(i_gid);
		
		setGalleryOptions(galleryVO);
		
		// 기본 이미지 정보가 없으므로 공백으로 세팅
		galleryVO.setG_origin_image("");
		galleryVO.setG_up_image("");
//		String i_gid = galleryVO.getG_id();
		
		int gRet = galleryDao.insert(galleryVO);
		
		// mapper 의 selectKey 에서 설정한 g_id 값을 참조할수 있다.
		 String i_gid = galleryVO.getG_id();
		
		List<ImageVO> resultNames = fileUploadService.filesUpload(image_files);
		
		
		int iRet = imagesDao.inserts(i_gid, resultNames);
		
		return null;
	}
	
	private void setGalleryOptions(GalleryVO vo) {
		LocalDateTime lt = LocalDateTime.now();
		DateTimeFormatter date = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		vo.setG_id(UUID.randomUUID().toString());
		vo.setG_date(lt.format(date));
		vo.setG_time(lt.format(time));
		
		vo.setG_author("n96js@naver.com");
	}
	
}
