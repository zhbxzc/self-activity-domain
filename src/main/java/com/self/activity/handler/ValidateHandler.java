package com.self.activity.handler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.self.activity.sdk.aop.BaseValidateHandler;

@Aspect
@Component
@Order(0)
public class ValidateHandler extends BaseValidateHandler {

	@Pointcut("execution(* com.self.activity.controller.*Controller.*(..))")
	public void validateMethod(){}
	
	@Around("validateMethod()")
	public Object validate(ProceedingJoinPoint joinPoint){
		return super.validate(joinPoint);
	}
}
