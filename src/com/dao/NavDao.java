package com.dao;

import java.util.List;

import com.entity.Nav;

public interface NavDao {
	List<Nav> navList();

	List<Nav> navFind(int id);

	List<Nav> navAllList();

	Boolean addNav(String parentId, String className);

	Nav getNavView(String id);

	Boolean modifyNav(String navId, String parentId, String className);

	Boolean deleteNav(String navId);
}
