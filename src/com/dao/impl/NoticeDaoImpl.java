package com.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.NoticeDao;
import com.entity.Notice;
import com.util.UtilByLiuQing;

public class NoticeDaoImpl implements NoticeDao {
	UtilByLiuQing lq = new UtilByLiuQing();

	@Override
	public List<Notice> noticeList() {
		List<Notice> noticelist = new ArrayList<Notice>(); // 存放公告的数组
		try {
			Connection conn = com.util.ConnDB.cpds.getConnection(); // 从连接池中获取链接
			String sql = "select * from notice order by timeCreated desc limit 7"; // 编写sql语句
			ResultSet rs = lq.execute(sql, conn); // 执行SQL语句返回结果集
			while (rs.next()) // 从结果集中去除对象放入数组中
			{
				Notice notice = new Notice(); // 公告对象
				notice.setNoticeId(rs.getInt("noticeId"));
				notice.setNoticeTitle(rs.getString("noticeTitle"));
				notice.setNoticeContent(rs.getString("noticeContent"));
				notice.setTimeCreated(rs.getTimestamp("timeCreated"));
				// 将对象放入数组
				noticelist.add(notice);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("NoticeDaoImpl出错");
			e.printStackTrace();
		}
		return noticelist;
	}

	// 查看公告信息
	@Override
	public Notice noticeDaoView(int id) {
		Notice notice = new Notice();
		try {
			Connection conn = com.util.ConnDB.cpds.getConnection(); // 从连接池中获取链接
			String sql = "select * from notice where noticeId=" + id; // 编写sql语句
			ResultSet rs = lq.execute(sql, conn); // 执行SQL语句返回结果集
			while (rs.next()) // 从结果集中取出对象放入
			{
				notice.setNoticeId(rs.getInt("noticeId"));
				notice.setNoticeTitle(rs.getString("noticeTitle"));
				notice.setNoticeContent(rs.getString("noticeContent"));
				notice.setTimeCreated(rs.getTimestamp("timeCreated"));
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("NoitceDaoImpl出错");
			e.printStackTrace();
		}
		return notice;
	}

}
