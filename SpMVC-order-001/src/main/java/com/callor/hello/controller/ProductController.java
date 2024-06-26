package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.hello.models.ProductVO;
import com.callor.hello.persistance.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/product")
public class ProductController {
	
	private final ProductDao productDao;
	
	public ProductController(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String Home(Model model) {
		
		List<ProductVO> pdList = productDao.selectAll();
		log.debug(pdList.toString());
		
		model.addAttribute("PD_LIST", pdList);
		
		
		
		return "/product/list";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		
		return "product/input";
	}
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(ProductVO vo) {
		
		log.debug(vo.toString());
		int result = productDao.insert(vo);
		
		return "redirect:/product";
	}
	
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(@RequestParam("p_code") String pCode ,Model model) {
		
		ProductVO productVO = productDao.findByPK(pCode);
		log.debug(productVO.toString());
		model.addAttribute("PD_LIST", productVO);
		
		
		
		return "product/detail";
	}
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public String update() {
		
		return "product/input";
	}
	
	
	

}
