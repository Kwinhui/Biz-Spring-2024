package com.callor.gallery.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.callor.gallery.models.GalleryVO;
import com.callor.gallery.service.GalleryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/gallery")
public class GalleryController {
	
	private final GalleryService galleryService;

	public GalleryController(GalleryService galleryService) {
		super();
		this.galleryService = galleryService;
	}

	@RequestMapping(value= {"","/"}, method=RequestMethod.GET)
	public String home(Model model) {
		
		List<GalleryVO> gList = galleryService.selectAll();
		model.addAttribute("GALLERYS",gList);
				
		return "gallery/list";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		
		
		return "gallery/input";
	}
	
	/*
	 * MultipartFile : form 의 input[type="file"] tag 담겨서 전달되는 
	 * 파일을 수신하는 객체
	 */
	// @RequestParam("image_file") MultipartFile image_file file일 경우 @Req 써줘야함
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(GalleryVO galleryVO, Model model,
				@RequestParam("image_file") MultipartFile image_file) {
		
		log.debug("파일업로드 {}", image_file.getOriginalFilename());
		// Exception 발생하기 때문에 try-catch
//		try {
//			fileUploadService.fileUpload(image_file);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		GalleryVO resultVO= null;
		try {
			resultVO = galleryService.createGallery(galleryVO,image_file);
			model.addAttribute("GALLERY", resultVO);
			log.debug("{}", resultVO.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("IMAGE", image_file.getOriginalFilename());
		return "gallery/input";
	}
}
