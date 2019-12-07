package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;

@WebFilter("/manage/*")
public class ManageFilter implements Filter {

    public ManageFilter() {
    }
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		User user = (User)session.getAttribute("User");
		if(user==null) {
			httpResponse.sendError(110, "不登陆就管理？！");
		}else {
			String name = user.getUserName();
			if(name.equals("admin") || name.equals("liuqing")) {
				chain.doFilter(request, response);
			}else {
				httpResponse.sendError(110, "你没有权限！");
			}
		}
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
