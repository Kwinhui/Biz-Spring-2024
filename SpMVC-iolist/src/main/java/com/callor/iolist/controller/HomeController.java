package com.callor.iolist.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.iolist.models.ioListVO;
import com.callor.iolist.persistance.ioListDao;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller

public class HomeController {
	
	private final ioListDao ioListDao;
	
	public HomeController(ioListDao ioListDao) {
		this.ioListDao = ioListDao;
	}
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<ioListVO> ioList = ioListDao.selectAll();
		
		model.addAttribute("ioList", ioList);
		
		log.debug(ioList.toString());
		
		
		return "home";
	}
	
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("io_seq") String ioSeq, Model model) {
		
		ioListVO vo = ioListDao.findById(ioSeq);
		
		model.addAttribute("ioList", vo);
		
		
		return "/detail";
		
	}
	
	
}
