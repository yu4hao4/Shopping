package com.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.Action;
import com.entity.Goods;
import com.service.ViewService;
import com.service.impl.ViewServiceImpl;

public class GoodsViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id")); //id为商品主键ID
		ViewService goodsView = new ViewServiceImpl();
		Goods goods = goodsView.goodsview(id);
		request.setAttribute("goods", goods);
		return "forward:goodsview.jsp"; //转发
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

}
