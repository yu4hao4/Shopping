package com.service.impl;

import java.util.List;

import com.dao.NewsDao;
import com.dao.impl.NewsDaoImpl;
import com.entity.News;
import com.service.NewsService;

public class NewsServiceImpl implements NewsService{

	//获取部分文档
	@Override
	public List<News> newsList() {
		NewsDao newsDao =new NewsDaoImpl();
		List<News> newslist = newsDao.newsList();
		return newslist;
	}

	//获取所有新闻
	@Override
	public List<News> navAllList() {
		NewsDao newsDao =new NewsDaoImpl();
		List<News> newslist = newsDao.newsAllList();
		return newslist;
	}

	//添加新闻
	@Override
	public Boolean addNews(String newsTitle, String newscontent, String time) {
		boolean flag = false;
		NewsDao newsDao =new NewsDaoImpl();
		flag =newsDao.addNews(newsTitle,newscontent,time);
		return flag;
	}

	//删除新闻
	@Override
	public Boolean deleteNews(String newsId) {
		NewsDao newsDao =new NewsDaoImpl();
		boolean flag = false;
		flag = newsDao.deleteNav(newsId);
		return flag;
	}

	//修改新闻
	@Override
	public Boolean modifyNews(String newsTitle, String newscontent, String time,String id) {
		boolean flag = false;
		NewsDao newsDao =new NewsDaoImpl();
		flag =newsDao.modifyNews(newsTitle,newscontent,time,id);
		return flag;
	}

}
