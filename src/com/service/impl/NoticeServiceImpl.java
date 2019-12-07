package com.service.impl;

import java.util.List;

import com.dao.NoticeDao;
import com.dao.impl.NoticeDaoImpl;
import com.entity.Notice;
import com.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {

	@Override
	public List<Notice> noticeList() {
		NoticeDao noticeDao =new NoticeDaoImpl();
		List<Notice> noticelist = noticeDao.noticeList();
		return noticelist;
	}

}
