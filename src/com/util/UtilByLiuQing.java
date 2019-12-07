package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilByLiuQing {
	public String TimeNow() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String timeCreated =df.format(new Date());//回复时间
		return timeCreated;
	}
	
	public ResultSet execute(String sql,Connection conn) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("工具类出错！");
			e.printStackTrace();
		}
		return rs;
	}
	
	public Integer execute2(String sql,Connection conn) {
		int rs = 0;
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("工具类出错！");
			e.printStackTrace();
		}
		return rs;
	}
}
