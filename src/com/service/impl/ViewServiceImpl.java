package com.service.impl;

import com.dao.GoodsViewDao;
import com.dao.NewsDao;
import com.dao.NoticeDao;
import com.dao.impl.GoodsViewDaoImpl;
import com.dao.impl.NewsDaoImpl;
import com.dao.impl.NoticeDaoImpl;
import com.entity.Goods;
import com.entity.News;
import com.entity.Notice;
import com.service.ViewService;

public class ViewServiceImpl implements ViewService {

	@Override
	public Goods goodsview(int id) {
		GoodsViewDao goodsViewDao =new GoodsViewDaoImpl();
		Goods goods = goodsViewDao.goodsview(id);
		return goods;
	}

	@Override
	public News newsView(int id) {
		NewsDao newsDao = new NewsDaoImpl();
		News news = newsDao.newsDaoView(id); 
		return news;
	}

	@Override
	public Notice noticeView(int id) {
		NoticeDao noticeDao = new NoticeDaoImpl();
		Notice notice = noticeDao.noticeDaoView(id); 
		return notice;
	}

}
