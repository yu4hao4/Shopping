package com.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.dao.NavDao;
import com.entity.Nav;
import com.util.UtilByLiuQing;

public class NavDaoImpl implements NavDao{
	UtilByLiuQing lq = new UtilByLiuQing();
	
	//获取前15个栏目作为首页
	@Override
	public List<Nav> navList() {
		List<Nav> navlist=new ArrayList<Nav>(); //存放栏目的数组
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection(); //从连接池中获取链接
			String sql = "select * from nav limit 15";  //编写sql语句
			ResultSet rs = lq.execute(sql, conn); //执行SQL语句返回结果集
			while(rs.next()) // 从结果集中去除对象放入数组中
			{
				Nav nav =new Nav(); //栏目对象
				nav.setNavId(rs.getInt("navId"));
				nav.setNavName(rs.getString("navName"));
				nav.setIsBelong(rs.getInt("isBelong"));
				//将对象放入数组
				navlist.add(nav);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("NavDaoImpl出错");
			e.printStackTrace();
		}
		return navlist;
	}
	@Override
	public List<Nav> navFind(int id) {
		List<Nav> navlist=new ArrayList<Nav>(); //存放栏目的数组
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection(); //从连接池中获取链接
			String sql = "select * from nav where isBelong="+id+" limit 15";  //编写sql语句
			ResultSet rs = lq.execute(sql, conn); //执行SQL语句返回结果集
			while(rs.next()) // 从结果集中去除对象放入数组中
			{
				Nav nav =new Nav(); //栏目对象
				nav.setNavId(rs.getInt("navId"));
				nav.setNavName(rs.getString("navName"));
				nav.setIsBelong(rs.getInt("isBelong"));
				//将对象放入数组
				navlist.add(nav);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("NavDaoImpl出错");
			e.printStackTrace();
		} 
		return navlist;
	}
	
	//全部遍历
	@Override
	public List<Nav> navAllList() {
		List<Nav> navlist=new ArrayList<Nav>(); //存放栏目的数组
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection(); //从连接池中获取链接
			String sql = "select * from nav";  //编写sql语句
			ResultSet rs = lq.execute(sql, conn); //执行SQL语句返回结果集
			while(rs.next()) // 从结果集中去除对象放入数组中
			{
				Nav nav =new Nav(); //栏目对象
				nav.setNavId(rs.getInt("navId"));
				nav.setNavName(rs.getString("navName"));
				nav.setIsBelong(rs.getInt("isBelong"));
				//将对象放入数组
				navlist.add(nav);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("NavDaoImpl出错");
			e.printStackTrace();
		}
		return navlist;
	}
	
	//添加栏目
	@Override
	public Boolean addNav(String parentId, String className) {
		boolean flag = false;
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "insert into nav(navName,isBelong) values('"+className+"',"+parentId+")";
			int rs = lq.execute2(sql, conn);//返回大于0代表成功
			if (rs > 0) {
				flag = true;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("NavDaoImpl出错！");
			e.printStackTrace();
		}
		return flag;
	}
	
	//获得栏目详情
	@Override
	public Nav getNavView(String id) {
		Nav nav=new Nav();
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "select * from nav where navId="+id;  //编写sql语句
 			ResultSet rs = lq.execute(sql, conn); //执行SQL语句返回结果集
 			while(rs.next()) // 从结果集中去除对象放入数组中
			{
				nav.setNavId(rs.getInt("navId"));
				nav.setNavName(rs.getString("navName"));
				nav.setIsBelong(rs.getInt("isBelong"));
			}
		} catch (SQLException e) {
			System.out.println("NavDaoImpl出错！");
			e.printStackTrace();
		}
		return nav;
	}
	
	//修改栏目
	@Override
	public Boolean modifyNav(String navId,String parentId, String className) {
		boolean flag = false;
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "update nav set navName='"+className+"',isBelong="+parentId+" where navId="+navId;
			int rs = lq.execute2(sql, conn);//返回大于0代表修改成功
			if (rs > 0) {
				flag = true;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("NavDaoImpl出错！");
			e.printStackTrace();
		}
		return flag;
	}
	
	//删除栏目
	@Override
	public Boolean deleteNav(String navId) {
		boolean flag = false;
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "delete from nav where navId="+navId;
			int rs = lq.execute2(sql, conn);//返回大于0代表修改成功
			if (rs > 0) {
				flag = true;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("NavDaoImpl出错！");
			e.printStackTrace();
		}
		return flag;
	}
	
}
