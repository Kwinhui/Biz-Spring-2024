package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.hello.models.CustomVO;
import com.callor.hello.persistance.CustomDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	private final CustomDao customDao;
	public CustomerController(CustomDao customDao) {
		this.customDao = customDao;
	}
	
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String home(Model model) {
		List<CustomVO> custList = customDao.selectAll();
		model.addAttribute("CUST_LIST", custList);
		
		return "custom/list";
	}
	
	// 고객정보를 입력하는 화면을 보여주는 메서드
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		
		
		
		return "custom/input";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(CustomVO vo, Model model) {
		
		try {
			int result = customDao.insert(vo);
			
			if(result > 0) {
				
				return "redirect:/customer";
			} else {
				model.addAttribute("MSG", "INSERT ERROR");
				return "custom/input";
			}
		} catch (Exception e) {
			model.addAttribute("MSG", "INSERT SQL ERROR");
			return "custom/input";
		}
		
	}
	
	/*
	 * 거래처 코드를 전달받아 거래처를 SELECT 하고
	 * SELECT 한 거래처 정보를 Detail 화면에서 보여주기
	 */
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(@RequestParam("c_code") String cCode, Model model, 
						@RequestParam(name="msg",required = false, defaultValue = "OK") String msg) {
							// msg 변수의 값은 있어도되고 없어도 됨
							// 값이 없으면 OK 라는 값을 담아라
		// js에서 document.location.href = `${rootPath}/customer/detail?c_code=${ccode}`;
		// c_code=${ccode} c_code에 ccode의 값을 넣어줘서 c_code로 매개변수를 받아야하지만
		// 나는 cCode로 사용을 하고싶다 라면 @RequestParam("c_code") 적어줘야함 
		
		
		CustomVO customVO = customDao.findById(cCode);
		
		model.addAttribute("CUST", customVO);
		model.addAttribute("MSG",msg);
		
		return "custom/detail";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@RequestParam("ccode") String cCode, Model model) {
		// query string
		CustomVO customVO = customDao.findById(cCode);
		model.addAttribute("CUST", customVO);
		return "custom/input"; 
	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(CustomVO customVO) {
		
		log.debug("Update {}", customVO.toString());
		
		int result = customDao.update(customVO);
		String retString = String.format("redirect:/customer/detail?c_code=%s", customVO.getC_code());
		return retString;
//		return "redirect:/custom/detail?c_code=" + customVO.getC_code();
	}
	
	/*
	 * URL(URI) 에 부착된 변수 값 추출하기
	 * @PathVariable("이름") 으로 값을 추출한다
	 */
	
	@RequestMapping(value="/delete/{ccode}", method=RequestMethod.GET)
	public String delete(@PathVariable("ccode") String cCode) {
		// url에 붙어있는 ccode 를 가져와 cCode 에 담아라
		int result = 0;
		try {
			result = customDao.delete(cCode);
			
		} catch (Exception e) {
			
			return "redirect:/customer/detail?c_code=" + cCode + "&msg=FK";
		}
		if(result > 0) {
			return "redirect:/customer";
		} else {
			return "redirect:/customer/detail?c_code=" + cCode + "&msg=NOT";
		}
			
		
	}
	
	
	


	
}
