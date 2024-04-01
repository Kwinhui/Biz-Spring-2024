package com.callor.iolist.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(Model model, ioListVO vo) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String currentDate = currentDateTime.format(dateFormatter);
        String currentTime = currentDateTime.format(timeFormatter);
        
        // 모델에 현재 날짜와 시간 추가
        model.addAttribute("currentDate", currentDate);
        model.addAttribute("currentTime", currentTime);
        model.addAttribute("ioList", vo);
	
		return "/input";
	}
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(ioListVO vo, Model model) {
		int result = ioListDao.insert(vo);
		log.debug(vo.toString());
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String currentDate = currentDateTime.format(dateFormatter);
        String currentTime = currentDateTime.format(timeFormatter);
        
        // 모델에 현재 날짜와 시간 추가
        model.addAttribute("currentDate", currentDate);
        model.addAttribute("currentTime", currentTime);
        
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("io_seq") String ioSeq, Model model) {
		
		ioListVO vo = ioListDao.findById(ioSeq);
		
		model.addAttribute("ioList", vo);
		
		
		return "/detail";
		
	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@RequestParam("io_seq")String ioSeq, Model model) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String currentDate = currentDateTime.format(dateFormatter);
        String currentTime = currentDateTime.format(timeFormatter);

        // 모델에 현재 날짜와 시간 추가
        model.addAttribute("currentDate", currentDate);
        model.addAttribute("currentTime", currentTime);
		ioListVO vo = ioListDao.findById(ioSeq);
		
		model.addAttribute("ioList", vo);
		
		
		return "/input";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(ioListVO ioListVO, Model model) {
		
		log.debug("UPDATE : {}", ioListVO);
		int result = ioListDao.update(ioListVO);
		
		return "redirect:/detail?io_seq=" + ioListVO.getIo_seq();
	}
	
	
	@RequestMapping(value="delete/{ioSeq}", method=RequestMethod.GET)
	public String delete(@PathVariable("ioSeq") String iSeq) {
		int result = 0;
		
		
		result = ioListDao.delete(iSeq);
		
		
		
		
		return "redirect:/";
	}
	
	
	
	
	
}
