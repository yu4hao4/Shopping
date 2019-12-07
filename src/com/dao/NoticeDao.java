package com.dao;

import java.util.List;

import com.entity.Notice;

public interface NoticeDao {
	List<Notice> noticeList();
	Notice noticeDaoView(int id);
}
