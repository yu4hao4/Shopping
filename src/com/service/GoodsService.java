package com.service;

import java.util.List;


import com.entity.Goods;

public interface GoodsService {
	List<Goods> goodsList(int id);
	List<Goods> goodsList(String name,int yeshu);
	int goodsIndex(String name);
	List<Goods> productList();
	Boolean deleteGoods(String goodsId);
	Boolean addGoods(String productName, String productPrice, String productContent, String isDiscount,
			String productImg, String productType);
	Boolean modifyGoods(String id, String productName, String parentId, String productPrice, String productContent,
			String isDiscount);
}
