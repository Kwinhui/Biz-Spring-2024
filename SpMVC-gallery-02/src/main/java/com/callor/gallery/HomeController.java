package com.callor.gallery;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.gallery.dao.GalleryDao;
import com.callor.gallery.models.GalleryVO;


@Controller
public class HomeController {
	
	private final GalleryDao galleryDao;
	
	
	
	public HomeController(GalleryDao galleryDao) {
		super();
		this.galleryDao = galleryDao;
	}



	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		model.addAttribute("NAME", "나는 이몽룡입니다");
		List<GalleryVO> gList = galleryDao.selectAll();
		model.addAttribute("GALLERYS", gList);
		
		return "home";
	}
	
}
