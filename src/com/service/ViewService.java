package com.service;

import com.entity.Goods;
import com.entity.News;
import com.entity.Notice;

public interface ViewService {
	Goods goodsview(int id);
	News newsView(int id);
	Notice noticeView(int id);
}
