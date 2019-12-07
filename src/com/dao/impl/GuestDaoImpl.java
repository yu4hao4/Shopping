package com.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.GuestDao;
import com.entity.Guest;
import com.util.UtilByLiuQing;

public class GuestDaoImpl implements GuestDao {
	UtilByLiuQing lq = new UtilByLiuQing();
	
	@Override
	public List<Guest> guestList(int yeshu) {
		List<Guest> guestlist = new ArrayList<Guest>();
		int index = (yeshu-1)*3; //从第0，3，6开始取
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "select * from guestbook order by timeCreated desc limit "+index+",3";  //编写sql语句 随机排序商品
 			ResultSet rs = lq.execute(sql, conn); //执行SQL语句返回结果集
 			while(rs.next()) // 从结果集中去除对象放入数组中
			{
				Guest guest =new Guest(); //商品对象
				guest.setGuestId(rs.getInt("guestId"));
				guest.setGuestTitle(rs.getString("guestTitle"));
				guest.setGuestContent(rs.getString("guestContent"));
				guest.setTimeCreated(rs.getTimestamp("timeCreated"));
				guest.setUserName(rs.getString("userName"));
				guest.setReply(rs.getString("reply"));
				guestlist.add(guest);
			}
 			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("GuestDaoImpl出错");
			e.printStackTrace();
		} 
		return guestlist;
	}

	//客人进行留言
	@Override
	public Boolean addBook(String guestTitle, String guestContent, String userName, String timeCreated) {
		boolean flag = false;//默认留言失败
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "insert into guestbook(guestTitle,guestContent,timeCreated,userName) values('" + guestTitle + "','" + 
			guestContent + "','"+timeCreated+"','"+userName+"');"; 
			int rs = lq.execute2(sql, conn);//返回大于0代表注册成功
			if (rs > 0) {
				flag = true;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("GuestDaoImpl出错");
			e.printStackTrace();
		}
		return flag;
	}

	//获得所有留言
	@Override
	public List<Guest> guestAllList() {
		List<Guest> guestlist = new ArrayList<Guest>();
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "select * from guestbook order by timeCreated desc";  //编写sql语句 随机排序商品
 			ResultSet rs = lq.execute(sql, conn); //执行SQL语句返回结果集
 			while(rs.next()) // 从结果集中去除对象放入数组中
			{
				Guest guest =new Guest(); //商品对象
				guest.setGuestId(rs.getInt("guestId"));
				guest.setGuestTitle(rs.getString("guestTitle"));
				guest.setGuestContent(rs.getString("guestContent"));
				guest.setTimeCreated(rs.getTimestamp("timeCreated"));
				guest.setUserName(rs.getString("userName"));
				guest.setReply(rs.getString("reply"));
				guestlist.add(guest);
			}
 			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("GuestDaoImpl出错");
			e.printStackTrace();
		} 
		return guestlist;
	}

	//删除留言
	@Override
	public Boolean deleteGuest(String guestId) {
		boolean flag = false;
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "delete from guestbook where guestId="+guestId;
			int rs = lq.execute2(sql, conn);//返回大于0代表修改成功
			if (rs > 0) {
				flag = true;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("GuestDaoImpl出错");
			e.printStackTrace();
		}
		return flag;
	}

	//修改留言
	@Override
	public Boolean modifyGuest(String id, String replyContent) {
		boolean flag = false;
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "update guestbook set reply='"+replyContent+"' where guestId="+id;
			int rs = lq.execute2(sql, conn);//返回大于0代表修改成功
			if (rs > 0) {
				flag = true;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("GuestDaoImpl出错");
			e.printStackTrace();
		}
		return flag;
	}

	//获得留言详情
	@Override
	public Guest getGuestView(String id) {
		Guest guest=new Guest();
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "select * from guestbook where guestId="+id;  //编写sql语句
 			ResultSet rs = lq.execute(sql, conn); //执行SQL语句返回结果集
 			while(rs.next()) // 从结果集中去除对象放入数组中
			{
 				guest.setGuestId(rs.getInt("guestId"));
				guest.setGuestTitle(rs.getString("guestTitle"));
				guest.setGuestContent(rs.getString("guestContent"));
				guest.setTimeCreated(rs.getTimestamp("timeCreated"));
				guest.setUserName(rs.getString("userName"));
				guest.setReply(rs.getString("reply"));
			}
		} catch (SQLException e) {
			System.out.println("guestDaoImpl出错！");
			e.printStackTrace();
		}
		return guest;
	}
	
	//获取留言总数
		@Override
		public Integer getIndex() {
			int counts = 0;
			try {
				Connection conn = com.util.ConnDB.cpds.getConnection();
				String sql = "select * from guestbook";  //编写sql语句
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

}
