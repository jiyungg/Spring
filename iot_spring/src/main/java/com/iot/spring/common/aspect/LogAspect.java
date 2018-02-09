package com.iot.spring.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.iot.spring.controller.EmpController;
import com.iot.spring.dao.TranslateDAO;
import com.iot.spring.vo.TranslateMessage;

@Aspect
public class LogAspect {
	private static final Logger log = LoggerFactory.getLogger(EmpController.class);
	private String name = "";
	@Autowired
	private TranslateDAO tdao;
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private ModelAndView mav;
	
	@Before("execution(* com.iot.spring.controller.EmpController.*(..)) or execution(* com.iot.spring.controller.UrlController.*(..))")
	public void beforePrint(JoinPoint jp){
		log.info("@Before Controller result =>{}", jp);
	}
	
	@Around("execution(* com.iot.spring.controller.EmpController.*(..)) or execution(* com.iot.spring.controller.UrlController.*(..))")
	public Object aroundPrint(ProceedingJoinPoint pjp) throws Throwable {
		name = pjp.getSignature().getDeclaringTypeName();

		log.info("@Around Info Bengin");
		log.info("{}.{}()", new Object[] { name,  pjp.getSignature().getName() });
		Object result = "error/error";

		try {
			result = pjp.proceed();
		} catch (Exception e) {
			String errorMsg = tdao.getText(e.getMessage());
			TranslateMessage tm = mapper.readValue(errorMsg, TranslateMessage.class);
			mav.addObject("tm", tm);
			log.error("@Around Error End");
			return mav;
		}
		log.info("@Around Info End");
		return result;
	}
	
	@AfterReturning("execution(* com.iot.spring.controller.EmpController.*(..))")
	public void empAfterReturningPrint(JoinPoint jp) {
		log.info("@AfterReturning EmpController result =>{}", jp);
	}
	@AfterReturning("execution(* com.iot.spring.controller.UrlController.*(..))")
	public void urlAfterReturningPrint(JoinPoint jp) {
		log.info("@AfterReturning UrlController result =>{}", jp);
	}
	
	@AfterThrowing(pointcut="execution(* com.iot.spring.controller.EmpController.*(..))", throwing="ex")
	public void errorPrint(JoinPoint jp, Throwable ex) {
		log.error("@AfterThrowing error=>{}", ex);
	}

	@After("execution(* com.iot.spring.controller.EmpController.*(..)) or execution(* com.iot.spring.controller.UrlController.*(..))")
	public void afterPrint(JoinPoint jp) {
		log.info("@After Controller result =>{}", jp);
	}
}
