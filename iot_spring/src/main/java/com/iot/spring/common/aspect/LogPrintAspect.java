package com.iot.spring.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
@Aspect
public class LogPrintAspect {
	private static final Logger log = LoggerFactory.getLogger(LogPrintAspect.class);
	@Before("execution(* com.iot.spring.controller.*Controller.*(..))")
	public void beforeLog(JoinPoint jp) {
		log.info("@Before =>{}", jp);
	}
	
	@Around("execution(* com.iot.spring.controller.*Controller.get*(..))")
	public Object aroundLog(ProceedingJoinPoint pjp) {
		log.info("@Around begin");
		Object obj = null;
		long startTime = System.currentTimeMillis();
		try {
			obj = pjp.proceed();
		} catch (Throwable e) {
			log.error("@Around error=>{}",e);
			ModelAndView mav = new ModelAndView("error/error");
			mav.addObject("errorMsg", e.getMessage());
			return mav;
		}
		log.info("@Around end, RunTime : {} ms",(System.currentTimeMillis()-startTime));
		return obj;
	}
	@After("execution(* com.iot.spring.controller.*Controller.*(..))")
	public void afterLog(JoinPoint jp) {
		log.info("@After =>{}", jp); 
	}
}
