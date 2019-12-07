package com.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.UserDao;
import com.entity.User;
import com.util.UtilByLiuQing;

public class UserDaoImpl implements UserDao {
	UtilByLiuQing lq = new UtilByLiuQing();
	
	//获得所有用户
	@Override
	public List<User> getUserList() {
		List<User> userList =new ArrayList<User>();
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "select * from user";  //编写sql语句
 			ResultSet rs = lq.execute(sql, conn); //执行SQL语句返回结果集
 			while(rs.next()) {
 				User u =new User();
 				u.setUserName(rs.getString("userName"));
 				u.setPassWord(rs.getString("passWord"));
 				u.setPersonName(rs.getString("personName"));
 				u.setSex(rs.getBoolean("sex"));
 				u.setBirthday(rs.getDate("birthday"));
 				u.setTelphone(rs.getString("telphone"));
 				u.setLocation(rs.getString("location"));
 				userList.add(u);
 			}
 			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("UserDaoImpl出错！");
			e.printStackTrace();
		} 
		return userList;
	}
	
	//获得用户的详细信息
	@Override
	public User getUserView(String userName) {
		User u = new User();
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "select * from user where userName='"+userName+"'";  //编写sql语句
 			ResultSet rs = lq.execute(sql, conn); //执行SQL语句返回结果集
 			while(rs.next()) {
 				u.setUserName(rs.getString("userName"));
 				u.setPassWord(rs.getString("passWord"));
 				u.setPersonName(rs.getString("personName"));
 				u.setSex(rs.getBoolean("sex"));
 				u.setBirthday(rs.getDate("birthday"));
 				u.setTelphone(rs.getString("telphone"));
 				u.setLocation(rs.getString("location"));
 			}
 			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("UserDaoImpl出错！");
			e.printStackTrace();
		}
		return u;
	}

	//修改用户
	@Override
	public boolean modifyUser(String userName, String personName, String passWord, String sex, String date,
			String telphone, String location) {
		boolean flag = false;
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "update user set personName='"+personName+"',passWord='"+passWord+"',sex="+
					sex+",birthday='"+date+"',telphone='"+telphone+"',location='"+location+"' where userName='"+userName+"';";
			int rs = lq.execute2(sql, conn);//返回大于0代表修改成功
			if (rs > 0) {
				flag = true;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("UserDaoImpl出错！");
			e.printStackTrace();
		}
		return flag;
	}

	//添加用户
	@Override
	public boolean AddUser(String userName, String personName, String passWord, String sex, String date,
			String telphone, String location) {
		boolean flag = false;
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql = "insert into user(userName,passWord,personName,sex,birthday,telphone,location) values('" + 
					userName + "','" + passWord + "','"+personName+"','"+sex+"','"+date+"','"+telphone+"','"+location+"');";
			int rs = lq.execute2(sql, conn);//返回大于0代表成功
			if (rs > 0) {
				flag = true;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("UserDaoImpl出错！");
			e.printStackTrace();
		}
		return flag;
	}

	//删除用户
	@Override
	public boolean DeleteUser(String userName) {
		boolean flag = false;
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();
			String sql ="delete from user where userName='"+userName+"';";
			int rs = lq.execute2(sql, conn);//返回大于0代表删除成功
			if (rs > 0) {
				flag = true;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("UserDaoImpl出错！");
			e.printStackTrace();
		}
		return flag;
	}

}
