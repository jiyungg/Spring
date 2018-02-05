package com.iot.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iot.spring.service.EmpService;
import com.iot.spring.vo.Emp;

@Controller
@RequestMapping("/emp")
public class EmpController {
	private static final Logger log = LoggerFactory.getLogger(UrlController.class);
	@Autowired
	private EmpService es;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getEmpList(Model m) {
		List<Emp>empList = es.getEmpList();
		m.addAttribute("emplist", empList);
		return "emp/jstl_list";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public ModelAndView insertEmp(
			@Valid Emp emp, Errors es,
			ModelAndView m) throws Exception {
		log.info("insert result => {} ", emp);
		if(es.hasErrors()) {
			log.info("error =>{}", es);
			throw new Exception(es.getAllErrors().get(0).getDefaultMessage());
		}
		m.setViewName("emp/wriwe");
		return m;
	} 
	public static void main(String[] args) {
		String str = "'empSal 필드에서 'emp'객체의 필드 오류 : 거부된 값 : [abc]";
		System.out.println(str.length());
	}
}

