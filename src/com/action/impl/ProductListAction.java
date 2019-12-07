package com.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.action.Action;
import com.service.GoodsService;
import com.service.impl.GoodsServiceImpl;

public class ProductListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		GoodsService goodsService = new GoodsServiceImpl();
		JSONArray goodslist = new JSONArray(goodsService.productList());
		return "JSONArray:" + goodslist.toString(2);
	}

	@Override
	public String executeM(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
