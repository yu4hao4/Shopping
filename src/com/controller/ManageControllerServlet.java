package com.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.action.impl.DeleteAction;
import com.action.impl.GoodsViewAction;
import com.action.impl.GuestListAction;
import com.action.impl.GuestViewAction;
import com.action.impl.NavAllListAction;
import com.action.impl.NavViewAction;
import com.action.impl.NewsAllListAction;
import com.action.impl.NewsViewAction;
import com.action.impl.ProductListAction;
import com.action.impl.UserAction;
import com.action.impl.UserSkillAction;
import com.action.impl.UserViewAction;


@MultipartConfig
@WebServlet({"/manage/userList_M","/manage/user-modify","/manage/manage-result","/manage/userDelete"
	,"/manage/navList_M","/manage/nav-modify","/manage/navDelete","/manage/newsList_M","/manage/news-view"
	,"/manage/guestList_M","/manage/guestbook-modify","/manage/productList","/manage/product-modify"})
public class ManageControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManageControllerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取请求名
		String actionName = getActionName(request.getRequestURI());
		//获得分发器
		Action action = null;
		//分发操作
		if(actionName.equals("userList_M")) {
			action = new UserAction();
		}else if(actionName.equals("user-modify")){
			action =new UserViewAction();
		}else if(actionName.equals("manage-result")){
			action = new UserSkillAction();
		}else if(actionName.equals("userDelete")){
			action =new DeleteAction();
		}else if(actionName.equals("navList_M")) {
			action = new NavAllListAction();
		}else if(actionName.equals("nav-modify")) {
			action = new NavViewAction();
		}else if(actionName.equals("navDelete")){
			action =new DeleteAction();
		}else if(actionName.equals("newsList_M")){
			action =new NewsAllListAction();
		}else if(actionName.equals("news-view")) {
			action = new NewsViewAction();
		}else if(actionName.equals("guestList_M")) {
			action = new GuestListAction();
		}else if(actionName.equals("guestbook-modify")) {
			action = new GuestViewAction();
		}else if(actionName.equals("productList")) {
			action = new ProductListAction();
		}else if(actionName.equals("product-modify")) {
			action = new GoodsViewAction();
		}else {
			throw new IllegalArgumentException("不存在的动作");
		}
		
		//分发视图
		String url =action.execute(request, response);
		String url1=url.split(":")[0];
		String url2 =url.substring(url.indexOf(":")+1);
		if(url1.equals("JSONArray")) {
			send(response,url2);
		}
		else if(url1.equals("forward")) {
			request.getRequestDispatcher(url2).forward(request, response);
		}
		else if(url1.equals("MoResult")) {
			String rs=url2.split(":")[1];
			if(rs.equals("true}")) {  //url2为 {MoResult:ture} 简单分割为true}
				response.sendRedirect("manage-result.html");
			}else {
				response.sendError(404,"修改失败");
			}
		}
		else if(url1.equals("AdResult")) {
			String rs=url2.split(":")[1];
			if(rs.equals("true}")) {  //url2为 {AdResult:ture} 简单分割为true}
				response.sendRedirect("manage-result.html");
			}else {
				response.sendError(404,"添加失败,可能因为已存在");
			}
		}
		else if(url1.equals("Result")) {
			send(response,url2);
		}
		else {
			response.sendError(404,"ManageCotrollerServlet发生错误");
		}
	}
	//分割请求名
	private String getActionName(String uri) {
		return uri.substring(uri.lastIndexOf("/")+1);
	}
	//反应消息发送给前端
		private void send(HttpServletResponse response,String goods) {
			response.setCharacterEncoding("UTF-8"); 
			response.setContentType("text/plain");
			Writer write;
			try {
				write = response.getWriter();
				write.write(goods);
				write.close();
			} catch (IOException e) {
				System.out.println("ConControllerServlet出错");
				e.printStackTrace();
			}
		}

}
