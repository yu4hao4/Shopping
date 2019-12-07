package com.service;

import java.util.List;

import com.entity.News;

public interface NewsService {
	List<News> newsList();

	List<News> navAllList();

	Boolean addNews(String newsTitle, String newscontent, String time);

	Boolean deleteNews(String newsId);

	Boolean modifyNews(String newsTitle, String newscontent, String time, String id);
}
