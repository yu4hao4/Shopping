 package com.action.impl;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.action.Action;
import com.entity.Goods;
import com.service.GoodsService;
import com.service.impl.GoodsServiceImpl;

public class GoodsListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		GoodsService goodsService = new GoodsServiceImpl();
		String sid = request.getParameter("id");
		if(sid==null || sid=="") {
			List<Goods> goodslist =null;
			String sname = request.getParameter("name");
			String syeshu =request.getParameter("yeshu");
			if(syeshu==null) {
				goodslist = goodsService.goodsList(sname,1);
			}else {
				int iyeshu = Integer.parseInt(syeshu);
				goodslist = goodsService.goodsList(sname,iyeshu);
			}
			
			int index = goodsService.goodsIndex(sname);//按照导航获得的商品总数
			int yeshu = (int) Math.ceil(index/12.0); //向上取整 一页最多展示12个商品
			request.setAttribute("goodslist", goodslist);
			request.setAttribute("yeshu", yeshu);
			return "forward:goods-list.jsp"; //转发
		}else {
			int id = Integer.parseInt(sid); //0为特价商品 1为热卖商品
			JSONArray goodslist = new JSONArray(goodsService.goodsList(id));
			return "JSONArray:" + goodslist.toString(2);
		}
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
