package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dao.GoodsDao;
import com.dao.impl.GoodsDaoImpl;
import com.entity.Goods;
import com.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {

	@Override
	public List<Goods> goodsList(int id) {
		GoodsDao goodsDao =new GoodsDaoImpl();
		List<Goods> goodslist = new ArrayList<Goods>();
		if(id==0) {
			goodslist = goodsDao.disgoodsList();
		}else if(id==1) {
			goodslist = goodsDao.goodsList();
		}
		return goodslist;
	}

	@Override
	public List<Goods> goodsList(String name,int yeshu) {
		GoodsDao goodsDao =new GoodsDaoImpl();
		List<Goods> goodslist = goodsDao.goodsList(name,yeshu);
		return goodslist;
	}

	@Override
	public int goodsIndex(String name) {
		GoodsDao goodsDao =new GoodsDaoImpl();
		int index = goodsDao.getIndex(name);
		return index;
	}

	//获得所有的商品
	@Override
	public List<Goods> productList() {
		GoodsDao goodsDao =new GoodsDaoImpl();
		List<Goods> goodslist = goodsDao.productList();
		return goodslist;
	}

	//删除商品
	@Override
	public Boolean deleteGoods(String goodsId) {
		GoodsDao goodsDao =new GoodsDaoImpl();
		boolean flag = false;
		flag = goodsDao.deleteGoods(goodsId);
		return flag;
	}

	//添加商品
	@Override
	public Boolean addGoods(String productName, String productPrice, String productContent, String isDiscount,
			String productImg,String productType) {
		GoodsDao goodsDao =new GoodsDaoImpl();
		boolean flag = false;
		flag = goodsDao.addGoods(productName,productPrice,productContent,isDiscount,productImg,productType);
		return flag;
	}

	//修改商品
	@Override
	public Boolean modifyGoods(String id, String productName, String productType, String productPrice,
			String productContent, String isDiscount) {
		GoodsDao goodsDao =new GoodsDaoImpl();
		boolean flag = false;
		flag = goodsDao.modifyGoods(id,productName,productPrice,productContent,isDiscount,productType);
		return flag;
	}

}
