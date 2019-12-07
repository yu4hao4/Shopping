package com.service.impl;

import java.util.List;


import com.dao.NavDao;
import com.dao.impl.NavDaoImpl;
import com.entity.Nav;
import com.service.NavService;

public class NavServiceImpl implements NavService{

	@Override
	public List<Nav> navList() {
		NavDao navDao =new NavDaoImpl();
		List<Nav> navlist = navDao.navList();
		return navlist;
	}

	@Override
	public List<Nav> navFind(int id) {
		NavDao navDao =new NavDaoImpl();
		List<Nav> navlist = navDao.navFind(id);
		return navlist;
	}

	//获取所有栏目
	@Override
	public List<Nav> navAllList() {
		NavDao navDao =new NavDaoImpl();
		List<Nav> navlist = navDao.navAllList();
		return navlist;
	}

	//添加栏目
	@Override
	public Boolean addNav(String parentId, String className) {
		boolean flag = false;
		NavDao navDao =new NavDaoImpl();
		flag =navDao.addNav(parentId,className);
		return flag;
	}

	//获得栏目详情
	@Override
	public Nav getNavView(String id) {
		NavDao navDao =new NavDaoImpl();
		return navDao.getNavView(id);
	}

	//修改栏目
	@Override
	public Boolean modifyNav(String navId,String parentId, String className) {
		NavDao navDao =new NavDaoImpl();
		boolean flag = false;
		flag = navDao.modifyNav(navId,parentId,className);
		return flag;
	}
	
	//删除栏目
	@Override
	public Boolean deleteNav(String navId) {
		NavDao navDao =new NavDaoImpl();
		boolean flag = false;
		flag = navDao.deleteNav(navId);
		return flag;
	}
	
}
