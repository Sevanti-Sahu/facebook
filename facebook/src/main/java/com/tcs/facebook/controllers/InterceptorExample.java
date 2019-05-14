package com.tcs.facebook.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//instead we can also implement HandlerInterceptor interface but in that all 3 methods needs to be mandatorily overridden

public class InterceptorExample extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(InterceptorExample.class);
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response ,Object Handler) throws Exception
	{
		long startTime = System.currentTimeMillis();
		logger.info("Request URL = " + request.getRequestURL() + "startTime : " + startTime);
		return true;
	}
	
	public void postHandle(HttpServletRequest request,HttpServletResponse response ,Object Handler) throws Exception
	{
		long startTime = System.currentTimeMillis();
		logger.info("Request URL = " + request.getRequestURL() + "startTime : " + startTime);
	}
	
	
	

}
