package com.filter;

import java.io.IOException;
import java.io.Writer;

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

import org.json.JSONObject;

import com.entity.Result;
import com.entity.User;


@WebFilter({"/guestBook"})
public class UserFilter implements Filter {

    public UserFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		User user = (User)session.getAttribute("User");
		if(user==null) { //未登录 可能通过注入session绕过前端认证 返回错误
			Result r = new Result(false);
			JSONObject jdata =new JSONObject(r);
			httpResponse.setCharacterEncoding("UTF-8");
			httpResponse.setContentType("text/plain");
			Writer write=httpResponse.getWriter();
			write.write(jdata.toString());
			write.close();
		}else { //登录放行
			
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
