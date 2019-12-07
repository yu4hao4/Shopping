package com.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.GoodsDao;
import com.entity.Goods;
import com.util.UtilByLiuQing;

public class GoodsDaoImpl implements GoodsDao {
	UtilByLiuQing lq = new UtilByLiuQing();
	
	//获取热卖商品数组
	@Override
	public List<Goods> goodsList() {
		List<Goods> goodslist=new ArrayList<>() ; //存放商品的数组
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection(); //从连接池中获取链接
			String sql = "select * from goods order by rand() limit 12";  //编写sql语句 随机排序商品
 			ResultSet rs = lq.execute(sql, conn); //执行SQL语句返回结果集
			while(rs.next()) // 从结果集中去除对象放入数组中
			{
				Goods goods =new Goods(); //商品对象
				goods.setGoodsId(rs.getInt("goodsId"));
				goods.setGoodsName(rs.getString("goodsName"));
				goods.setGoodsPrice(rs.getDouble("goodsPrice"));
				goods.setGoodsContent(rs.getString("goodsContent"));
				goods.setGoodsType(rs.getString("goodsType"));
				goods.setGoodsImg(rs.getString("goodsImg"));
				goods.setIsDiscount(rs.getDouble("isDiscount"));
				goodslist.add(goods);
			}
		
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("GoodsDaoImpl出错");
			e.printStackTrace();
		}
		return goodslist;
	}
	
	//获取折扣商品数组
	@Override
	public List<Goods> disgoodsList() {
		List<Goods> disgoods =new ArrayList<Goods>(); //存放折扣商品的数组
		try {
			Connection conn = com.util.ConnDB.cpds.getConnection();//从连接池中获取链接
			String sql = "select * from goods where isDiscount <1 order by rand() limit 8";  //编写sql语句 随机排序商品
			ResultSet rs = lq.execute(sql, conn); //执行SQL语句返回结果集
			while(rs.next()) // 从结果集中去除对象放入数组中
			{
				Goods goods =new Goods(); //商品对象
				goods.setGoodsId(rs.getInt("goodsId"));
				goods.setGoodsName(rs.getString("goodsName"));
				goods.setGoodsPrice(rs.getDouble("goodsPrice"));
				goods.setGoodsContent(rs.getString("goodsContent"));
				goods.setGoodsType(rs.getString("goodsType"));
				goods.setGoodsImg(rs.getString("goodsImg"));
				goods.setIsDiscount(rs.getDouble("isDiscount"));
				disgoods.add(goods);//	将对象放入数组
			}
			
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("GoodsDaoImpl出错");
			e.printStackTrace();
		} 
		
		return disgoods;
	}

	//根据导航获取商品的数组
	@Override
	public List<Goods> goodsList(String name,int yeshu) {
		List<Goods> goodslist =new ArrayList<Goods>(); //存放商品的数组
		int index = (yeshu-1)*12; //从第0，12，24开始取
		try {
			Connection conn = com.util.ConnDB.cpds.getConnection();
			String sql = "select * from goods where goodsType='"+name+"' limit "+index+",12";  //编写sql语句
			ResultSet rs = lq.execute(sql, conn); //执行SQL语句返回结果集
			while(rs.next()) // 从结果集中去除对象放入数组中
			{
				Goods goods =new Goods(); //商品对象
				goods.setGoodsId(rs.getInt("goodsId"));
				goods.setGoodsName(rs.getString("goodsName"));
				goods.setGoodsPrice(rs.getDouble("goodsPrice"));
				goods.setGoodsContent(rs.getString("goodsContent"));
				goods.setGoodsType(rs.getString("goodsType"));
				goods.setGoodsImg(rs.getString("goodsImg"));
				goods.setIsDiscount(rs.getDouble("isDiscount"));
				goodslist.add(goods);//	将对象放入数组
			}
			
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("GoodsDaoImpl出错");
			e.printStackTrace();
		}
		return goodslist;
	}

	//获取按照导航的商品总数
	@Override
	public int getIndex(String name) {
		int counts = 0;
		try {
			Connection conn = com.util.ConnDB.cpds.getConnection();
			String sql = "select * from goods where goodsType='"+name+"'";  //编写sql语句
			ResultSet rs = lq.execute(sql, conn); //执行SQL语句返回结果集
			while(rs.next())
			{
				counts++;
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("GoodsDaoImpl出错");
			e.printStackTrace();
		}
		return counts;
	}

	//获得所有商品
	@Override
	public List<Goods> productList() {
		List<Goods> goodslist=new ArrayList<Goods>(); //存放栏目的数组
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection(); //从连接池中获取链接
			String sql = "select * from goods";  //编写sql语句
			ResultSet rs = lq.execute(sql, conn); //执行SQL语句返回结果集
			while(rs.next()) // 从结果集中去除对象放入数组中
			{
				Goods goods =new Goods(); //商品对象
				goods.setGoodsId(rs.getInt("goodsId"));
				goods.setGoodsName(rs.getString("goodsName"));
				goods.setGoodsPrice(rs.getDouble("goodsPrice"));
				goods.setGoodsContent(rs.getString("goodsContent"));
				goods.setGoodsType(rs.getString("goodsType"));
				goods.setGoodsImg(rs.getString("goodsImg"));
				goods.setIsDiscount(rs.getDouble("isDiscount"));
				goodslist.add(goods);//	将对象放入数组
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("GoodsDaoImpl出错");
			e.printStackTrace();
		}
		return goodslist;
	}

	//删除商品
	@Override
	public Boolean deleteGoods(String goodsId) {
		boolean flag = false;
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "delete from goods where goodsId="+goodsId;
			int rs = lq.execute2(sql, conn);//返回大于0代表修改成功
			if (rs > 0) {
				flag = true;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("GoodsDaoImpl出错");
			e.printStackTrace();
		}
		return flag;

	}

	//添加商品
	@Override
	public Boolean addGoods(String productName, String productPrice, String productContent, String isDiscount,
			String productImg,String productType) {
		boolean flag = false;
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "insert into goods(goodsName,goodsPrice,goodsContent,goodsType,goodsImg,isDiscount) values('"+
			productName+"',"+productPrice+",'"+productContent+"','"+productType+"','"+productImg+"',"+
					isDiscount+")";
			int rs = lq.execute2(sql, conn);//返回大于0代表成功
			if (rs > 0) {
				flag = true;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("GoodsDaoImpl出错");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Boolean modifyGoods(String id, String productName, String productPrice, String productContent,
			String isDiscount, String productType) {
		boolean flag = false;
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "update goods set goodsName='"+productName+"',goodsPrice="+productPrice+",goodsContent='"+
			productContent+"',isDiscount="+isDiscount+",goodsType='"+productType+"' where goodsId="+id;
			int rs = lq.execute2(sql, conn);//返回大于0代表成功
			if (rs > 0) {
				flag = true;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("GoodsDaoImpl出错");
			e.printStackTrace();
		}
		return flag;
	}

}
