package com.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.action.Action;
import com.entity.Result;
import com.service.GoodsService;
import com.service.GuestService;
import com.service.NavService;
import com.service.NewsService;
import com.service.UserService;
import com.service.impl.GoodsServiceImpl;
import com.service.impl.GuestServiceImpl;
import com.service.impl.NavServiceImpl;
import com.service.impl.NewsServiceImpl;
import com.service.impl.UserServiceImpl;

public class DeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		String navId =request.getParameter("navId");
		String newsId =request.getParameter("newsId");
		String guestId =request.getParameter("guestId");
		String goodsId=request.getParameter("goodsId");
		
		boolean flag=false;
		if(userName!=null && navId==null&&newsId==null&&guestId==null&&goodsId==null) {  //用户删除
			UserService userService = new UserServiceImpl();
			flag = userService.deleteUser(userName);
		}else if(userName==null && navId!=null&&newsId==null&&guestId==null&&goodsId==null) { //栏目删除
			NavService navService =new NavServiceImpl();
			flag = navService.deleteNav(navId);
		}else if(userName==null && navId==null&&newsId!=null&&guestId==null&&goodsId==null) { //新闻删除
			NewsService newsService =new NewsServiceImpl();
			flag = newsService.deleteNews(newsId);
		}else if(userName==null && navId==null&&newsId==null&&guestId!=null&&goodsId==null) { //留言删除
			GuestService newsService =new GuestServiceImpl();
			flag = newsService.deleteGuest(guestId);
		}else if(userName==null && navId==null&&newsId==null&&guestId==null&&goodsId!=null) { //留言删除
			GoodsService goodsService =new GoodsServiceImpl();
			flag = goodsService.deleteGoods(goodsId);
		}
		
		JSONObject jdata =null;  //存放结果
		Result r = new Result(flag);
		jdata =new JSONObject(r);
		return "Result:"+jdata.toString();
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
