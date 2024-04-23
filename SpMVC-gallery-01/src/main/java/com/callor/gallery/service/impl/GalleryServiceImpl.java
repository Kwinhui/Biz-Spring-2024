package com.callor.gallery.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.callor.gallery.dao.GalleryDao;
import com.callor.gallery.models.GalleryVO;
import com.callor.gallery.service.GalleryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GalleryServiceImpl implements GalleryService{
	/*
	 * 입력화면에서 제목, 내용, 이미지(base64)를 전달받고
	 * 여기에 작성일자, 작성시각, PK 값을 생성하여 VO 를 다시 세팅하고
	 * Dao 에 전달하여 데이터를 insert 하기
	 */
	private final GalleryDao galleryDao;
	public GalleryServiceImpl(GalleryDao galleryDao) {
		super();
		this.galleryDao = galleryDao;
	}


	@Override
	public GalleryVO createGallery(GalleryVO vo) {
		
		LocalDateTime lt = LocalDateTime.now();
		DateTimeFormatter date = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		/*
		 * UUID v5(또는 v4) 를 사용하기 위하여 randomUUID() method 를 호출하여
		 * UUID 값을 만들기
		 */
		
		vo.setG_id(UUID.randomUUID().toString());
		// 날짜와 시간을 현재날짜와 시간으로 바꿔주기
		vo.setG_date(lt.format(date));
		vo.setG_time(lt.format(time));
		vo.setG_author("n96js@naver.com");
		// input.jsp 에서 원래 입력받았던 g_id, g_date, g_time, g_author를 없애버렸기 때문에
		// serviceimpl 에서 세팅해주기
		
		log.debug("ID {}, date {}, time {} Subject {}",
					vo.getG_id(), vo.getG_date(), vo.getG_time(), vo.getG_subject());
		
		int ret = galleryDao.insert(vo);
		if(ret > 0) {
			return vo;
		}
		
		return null;
		
	}

}
