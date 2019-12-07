package com.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.NewsDao;
import com.entity.News;
import com.util.UtilByLiuQing;

public class NewsDaoImpl implements NewsDao {
	UtilByLiuQing lq = new UtilByLiuQing();
	@Override
	public List<News> newsList() {
		List<News> newslist=new ArrayList<News>(); //存放新闻的数组
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection(); //从连接池中获取链接
			String sql = "select * from news order by timeCreated desc limit 7";  //编写sql语句
			ResultSet rs = lq.execute(sql, conn); //执行SQL语句返回结果集
			while(rs.next()) // 从结果集中去除对象放入数组中
			{
				News news =new News(); //新闻对象
				news.setNewsId(rs.getInt("newsId"));
				news.setNewsTitle(rs.getString("newsTitle"));
				news.setNewsContent(rs.getString("newsContent"));
				news.setTimeCreated(rs.getTimestamp("timeCreated"));
				//将对象放入数组
				newslist.add(news);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("NewsDaoImpl出错");
			e.printStackTrace();
		}
		return newslist;
	}
	
	//查看新闻信息
	@Override
	public News newsDaoView(int id) {
		News news =new News();
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection(); //从连接池中获取链接
			String sql = "select * from news where newsId="+id;  //编写sql语句
			ResultSet rs = lq.execute(sql, conn); //执行SQL语句返回结果集
			while(rs.next()) // 从结果集中去除对象放入数组中
			{
				news.setNewsId(rs.getInt("newsId"));
				news.setNewsTitle(rs.getString("newsTitle"));
				news.setNewsContent(rs.getString("newsContent"));
				news.setTimeCreated(rs.getTimestamp("timeCreated"));
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("NewsDaoImpl出错");
			e.printStackTrace();
		}
		return news;
	}

	//遍历所有新闻
	@Override
	public List<News> newsAllList() {
		List<News> newslist=new ArrayList<News>(); //存放新闻的数组
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection(); //从连接池中获取链接
			String sql = "select * from news order by timeCreated desc";  //编写sql语句
			ResultSet rs = lq.execute(sql, conn); //执行SQL语句返回结果集
			while(rs.next()) // 从结果集中去除对象放入数组中
			{
				News news =new News(); //新闻对象
				news.setNewsId(rs.getInt("newsId"));
				news.setNewsTitle(rs.getString("newsTitle"));
				news.setNewsContent(rs.getString("newsContent"));
				news.setTimeCreated(rs.getTimestamp("timeCreated"));
				//将对象放入数组
				newslist.add(news);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("NewsDaoImpl出错");
			e.printStackTrace();
		}
		return newslist;
	}

	//添加新闻
	@Override
	public Boolean addNews(String newsTitle, String newscontent, String time) {
		boolean flag = false;
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "insert into news(newsTitle,newsContent,timeCreated) values('"+newsTitle+"','"+newscontent+"','"+
			time+"')";
			int rs = lq.execute2(sql, conn);//返回大于0代表成功
			if (rs > 0) {
				flag = true;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("NewsDaoImpl出错");
			e.printStackTrace();
		}
		return flag;
	}

	//删除新闻
	@Override
	public Boolean deleteNav(String newsId) {
		boolean flag = false;
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "delete from news where newsId="+newsId;
			int rs = lq.execute2(sql, conn);//返回大于0代表修改成功
			if (rs > 0) {
				flag = true;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("NewsDaoImpl出错");
			e.printStackTrace();
		}
		return flag;
	}

	//修改新闻
	@Override
	public Boolean modifyNews(String newsTitle, String newscontent, String time,String id) {
		boolean flag = false;
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "update news set newsTitle='"+newsTitle+"',newsContent='"+newscontent+"',timeCreated='"+
			time+"' where newsId="+id;
			int rs = lq.execute2(sql, conn);//返回大于0代表成功
			if (rs > 0) {
				flag = true;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("NewsDaoImpl出错");
			e.printStackTrace();
		}
		return flag;

	}

}
