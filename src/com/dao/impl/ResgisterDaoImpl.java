package com.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.ResgisterDao;
import com.util.UtilByLiuQing;

public class ResgisterDaoImpl implements ResgisterDao {
	UtilByLiuQing lq = new UtilByLiuQing();
	@Override
	public Boolean registerUser(String userName, String passWord) {
		boolean flag = false;//默认注册失败或者存在
		try {
			Connection conn=com.util.ConnDB.cpds.getConnection();//从连接池中获取链接
			boolean end = check(userName,conn);//进行用户名检查，如果已经存在则返回true
			if(end==true){
				conn.close();
				return flag;
			}else {
				String sql = "insert into user(userName,passWord) values('" + userName + "','" + passWord + "');";
				int rs = lq.execute2(sql, conn);//返回大于0代表注册成功
				if (rs > 0) {
					flag = true;
				}
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("ResgisterDaoImpl出错！");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean check(String userName,Connection conn){
		boolean flag = false;  //true表示存在,false表示不存在
		String sql = "select * from user where userName = '" +userName + "';";
		ResultSet rs = lq.execute(sql, conn);
		 int count = 0;
         try {
			while(rs.next()){
			 	count++;
			 }
		} catch (SQLException e) {
			System.out.println("ResgisterDaoImpl出错！");
			e.printStackTrace();
		}
         if(count>0){
      		flag=true;
      	}
        try {
			rs.close();
		} catch (SQLException e) {
			System.out.println("ResgisterDaoImpl出错！");
			e.printStackTrace();
		}
		return flag;
	}

}
