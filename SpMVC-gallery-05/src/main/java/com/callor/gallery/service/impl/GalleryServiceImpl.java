package com.callor.gallery.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import com.callor.gallery.models.ImagesVO;
import com.callor.gallery.service.FileService;
import com.callor.gallery.service.GalleryService;
import com.callor.gallery.utils.Names;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GalleryServiceImpl implements GalleryService{
	private final FileService fileService;
	private final GalleryDao galleryDao;
	private final ImageDao imageDao;
	public GalleryServiceImpl(FileService fileService, GalleryDao galleryDao, ImageDao imageDao) {
		super();
		this.fileService = fileService;
		this.galleryDao = galleryDao;
		this.imageDao = imageDao;
	}

	@Autowired
	public void create_table() {
		galleryDao.create_table();
		imageDao.create_table();
	}
	@Transactional
	@Override
	public int createGallerys(GalleryVO galleryVO, MultipartHttpServletRequest files) {
		
		List<MultipartFile> fileList = files.getFiles(Names.FILES);
		List<ImagesVO> images = new ArrayList<>();
//		String g_id = UUID.randomUUID().toString();
//		galleryVO.setG_id(g_id);
		
		this.setGalleryVO(galleryVO);
		// 올라온파일 1개이상
		if(fileList.size() > 1) {
			images = fileService.filesUp(files);
			// 대표이미지
			galleryVO.setG_image(images.get(0).getI_up_image());
			
		} else {
			// 1개일때
			String name = fileService.fileUp(fileList.get(0));
			galleryVO.setG_image(name);
					
		}
		log.debug("갤러리{}",galleryVO.toString());
		
		int ret = galleryDao.insert(galleryVO);
		if(images.size() > 1) {
			
			ret = imageDao.inserts(galleryVO.getG_id(), images);
		}
		return ret;
		
		

	}
	/*
	 * GalleryVO 객체를 매개변수로 전달받아
	 * 각 요소속성(g_id,g_date,g_time) 을 변경하고 있다.
	 * 이때 setGalleryVO() method 는 GalleryVO 객체를 Call By Reference 로
	 * 받은것과 동일하게 작동된다.
	 */

	private void setGalleryVO(GalleryVO galleryVO) {
		
		String g_id = UUID.randomUUID().toString();
		
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter today = DateTimeFormatter.ofPattern("YYYY-HH-dd");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		galleryVO.setG_id(g_id);
		galleryVO.setG_date(dateTime.format(today));
		galleryVO.setG_time(dateTime.format(time));
		
	}

	@Override
	public List<GalleryVO> selectAll() {

		return galleryDao.selectAll();
	}

	@Override
	public GalleryVO selectGalleryOne(String gid) {
		
		GalleryVO vo = galleryDao.findById(gid);
		List<ImagesVO> images = imageDao.findByGid(gid);
		vo.setG_images(images);
		return vo;
	}

	/*
	 * 파일이 첨부된 데이터를 삭제하기
	 * 1. 첨부파일을 먼저 삭제해야 한다.
	 *  a. DB의 데이터를 SELECT 하고,
	 *  b. DB 정보에 있는 파일들을 삭제하고,
	 *  
	 * 2. Table 의 데이터를 DELETE
	 */
	@Override
	public int delete(String id) {
		// a
		List<ImagesVO> images = imageDao.findByGid(id);
		// 한개의 파일이 DB에 저장안됨
		for(ImagesVO vo : images) {
			// vo를 보내서 파일 삭제
			fileService.fileDelete(vo.getI_up_image());
		}
		// 파일 한개를 올렸을때의 data를 삭제하기위해
		GalleryVO gaVO = galleryDao.findById(id);
		fileService.fileDelete(gaVO.getG_image());
		
		galleryDao.delete(id);
		
		// 이미지가 한개일때 업데이트 할 경우는 원래 있던 이미지는 삭제후 업데이트
		return 0;
	}
	
}
