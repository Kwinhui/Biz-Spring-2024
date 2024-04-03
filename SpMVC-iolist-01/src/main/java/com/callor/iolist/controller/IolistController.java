package com.callor.iolist.controller;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.iolist.models.IoListVO;
import com.callor.iolist.persistance.IoListDao;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping(value="/iolist")
public class IolistController {
	private final IoListDao iolistDao;
	public IolistController(IoListDao iolistDao) {
		this.iolistDao = iolistDao;
	}
	
	
	@RequestMapping(value= {"/", ""}, method=RequestMethod.GET)
	public String home(Model model) {


		
		// BODY 라는 변수에 IOLIST_HOME 이라는 문자열을 담음
		model.addAttribute("BODY", "IOLIST_HOME");
		List<IoListVO> iolist = iolistDao.selectAll();
		model.addAttribute("IOLIST", iolist);
		return "layout";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(Model model) {
		// 날짜와 관련된 java 1.8 이전버전의 클래스
				Date today = new Date();
				// 몇일전 몇일후 계산과 관련된 클래스, 문자열로 만들땐 format 같은것이 필요없음
				Calendar ca = Calendar.getInstance();
				
				// java 1.8 이상에서 사용하는 클래스
				LocalDate localDate = LocalDate.now();
				LocalTime localTime = LocalTime.now();
				// 용량이 큼
				LocalDateTime localDateTime = LocalDateTime.now();
				
				DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
				
				/**
				 * Builder Pattern 을 사용하여 IoListVO 객체 생성하기
				 * Builder Pattern 을 사용하면 필요한 필드에 값만 셋팅하면서
				 * 객체를 생성할 수 있다.
				 */
				
//				IoListVO vo =new IoListVO();
//				vo.setIo_date(localDateTime.format(dayFormat));
//				vo.setIo_time(localDateTime.format(timeFormat));
				
				// 위아래 둘중 아무거나 써도됨
				IoListVO vo = IoListVO.builder()
						.io_date(localDateTime.format(dayFormat))
						.io_time(localDateTime.format(timeFormat))
						.build();
				model.addAttribute("IO", vo);
				log.debug(vo.toString());
		
		
		// BODY 라는 변수에 IOLIST_INPUT 이라는 문자열을 담음
		model.addAttribute("BODY", "IOLIST_INPUT");
	return "layout";	

	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(IoListVO iolistVO, Model model) {
		
		log.debug(iolistVO.toString());
		int result = iolistDao.insert(iolistVO);
		if(result > 0) {
			return "redirect:/iolist/";
			
		} else {
			model.addAttribute("BODY", "IOLIST_INPUT");
			return "layout";
		}
		
	}
	
}
