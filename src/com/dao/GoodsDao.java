package com.dao;

import java.util.List;

import com.entity.Goods;

public interface GoodsDao {
	List<Goods> disgoodsList(); //获取打折商品
	List<Goods> goodsList(); //获取热卖商品
	List<Goods> goodsList(String name,int yeshu); //按导航获取商品
	int getIndex(String name); //按照导航获取商品总数
	List<Goods> productList(); //获得所有商品
	Boolean deleteGoods(String goodsId);
	Boolean addGoods(String productName, String productPrice, String productContent, String isDiscount,
			String productImg, String productType);
	Boolean modifyGoods(String id, String productName, String productPrice, String productContent, String isDiscount,
			String productType);
}
