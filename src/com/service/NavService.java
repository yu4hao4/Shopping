package com.service;


import java.util.List;


import com.entity.Nav;


public interface NavService {
	List<Nav> navList();
	List<Nav> navFind(int id);
	List<Nav> navAllList();
	Boolean addNav(String parentId, String className);
	Nav getNavView(String id);
	Boolean modifyNav(String navId, String parentId, String className);
	Boolean deleteNav(String navId);
}
