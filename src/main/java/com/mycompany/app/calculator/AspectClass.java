package com.mycompany.app.calculator;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass {
	Logger logger = Logger.getLogger(AspectClass.class.getName());

	@Before("execution(* com.mycompany.app.calculator.*.*(..))")
	public void log() {
		logger.info("Before logging the method");
	}

	@After("execution(* com.mycompany.app.calculator.*.*(..))")
	public void log2() {
		logger.info("After logging the method");
	}
	@Around("execution(* com.mycompany.app.calculator.*.*(..))")
	public Object log3(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("Around before loging method");
		logger.info("Function name is:"+pjp.getSignature());
		logger.info("Parameters are");
		Object[] params=pjp.getArgs();
		for(int i=0;i<params.length;i++)
		{
			logger.info("Parameter value at index" + i +"is"+params[i]);
		}
		Object retVal = pjp.proceed();
		logger.info("After logging using Around method");
		return retVal;
	}	
	@AfterReturning(pointcut="execution(* com.mycompany.app.calculator.*.*(..))",returning ="retVal")
	public void log4(Integer retVal) {
		logger.info("value"+ retVal);
	}
	@AfterThrowing(pointcut="execution(* com.mycompany.app.calculator.*.*(..))",throwing="exe")
	public void log5(Exception exe) {
		logger.info("exception is"+ exe);
	}
	}
