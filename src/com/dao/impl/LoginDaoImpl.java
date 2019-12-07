package com.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.LoginDao;
import com.entity.User;
import com.util.UtilByLiuQing;


public class LoginDaoImpl implements LoginDao {
	UtilByLiuQing lq = new UtilByLiuQing();
	@Override
	public User login(String userName, String passWord) {
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();//从连接池中获取链接
			String sql = "select * from user where username='" + userName +"'";
			ResultSet rs = lq.execute(sql, conn);
			if(rs == null)
			{
			conn.close();
			return null;
			}
			while(rs.next()) // 
			{
				String username = rs.getString("userName");
				String userpassword=rs.getString("passWord");
				if(userpassword.equals(passWord))
				{
					User user = new User();
					user.setUserName(username);
					user.setPassWord(userpassword);
					rs.close();
					conn.close();
					return user;
				}
			}
		} catch (SQLException e) {
			System.out.println("LoginDaoImpl出错");
			e.printStackTrace();
		}
		
		return null;
	}

}
