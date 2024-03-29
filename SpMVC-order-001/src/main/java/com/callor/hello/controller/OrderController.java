package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.models.OrderCustomVO;
import com.callor.hello.persistance.OrderCustomDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/order")
public class OrderController {
	
//	private final OrderDao orderDao;
//	public OrderController(OrderDao orderDao) {
//		this.orderDao = orderDao;
//	}
	
	private final OrderCustomDao orderDao;
	public OrderController(OrderCustomDao orderDao) {
		this.orderDao = orderDao;
	}
		
	
	
	@RequestMapping(value= {"/",""}, method = RequestMethod.GET)
	public String home(Model model) {
		
		List<OrderCustomVO> odList = orderDao.selectAll();
		log.debug(odList.toString());
		model.addAttribute("OD_LIST", odList);
		
		return "order/list";
		
	}
	
	

	
	
	
}
