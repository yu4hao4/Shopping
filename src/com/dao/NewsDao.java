package com.dao;

import java.util.List;

import com.entity.News;

public interface NewsDao {
	List<News> newsList();
	News newsDaoView(int id);
	List<News> newsAllList();
	Boolean addNews(String newsTitle, String newscontent, String time);
	Boolean deleteNav(String newsId);
	Boolean modifyNews(String newsTitle, String newscontent, String time, String id);
}
