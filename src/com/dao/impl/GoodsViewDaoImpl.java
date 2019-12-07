package com.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.GoodsViewDao;
import com.entity.Goods;
import com.util.UtilByLiuQing;

public class GoodsViewDaoImpl implements GoodsViewDao {

	UtilByLiuQing lq = new UtilByLiuQing();
	
	@Override
	public Goods goodsview(int id) {
		Goods goods =new Goods(); //商品对象
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();//从连接池中获取链接
			String sql = "select * from goods where goodsId="+id;  //编写sql语句
			ResultSet rs = lq.execute(sql, conn); //执行SQL语句返回结果集
			while(rs.next()) // 从结果集中去除对象放入数组中
			{
				goods.setGoodsId(rs.getInt("goodsId"));
				goods.setGoodsName(rs.getString("goodsName"));
				goods.setGoodsPrice(rs.getDouble("goodsPrice"));
				goods.setGoodsContent(rs.getString("goodsContent"));
				goods.setGoodsType(rs.getString("goodsType"));
				goods.setGoodsImg(rs.getString("goodsImg"));
				goods.setIsDiscount(rs.getDouble("isDiscount"));
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("GoodsViewDaoImpl出错");
			e.printStackTrace();
		}
		return goods;
	}

}
