package com.action;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface Action {
	String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
	
	//管理员用的
	String executeM(HttpServletRequest request, HttpServletResponse response);
}
