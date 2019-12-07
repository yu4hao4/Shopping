package com.service.impl;

import java.util.List;

import com.dao.GuestDao;
import com.dao.impl.GuestDaoImpl;
import com.entity.Guest;
import com.service.GuestService;

public class GuestServiceImpl implements GuestService {

	//获取留言
	@Override
	public List<Guest> guestList(int yeshu) {
		GuestDao guestDao =new GuestDaoImpl();
		List<Guest> guestlist = guestDao.guestList(yeshu);
		return guestlist;
	}

	//客户进行留言
	@Override
	public Boolean addBook(String guestTitle, String guestContent, String userName, String timeCreated) {
		GuestDao guestDao =new GuestDaoImpl();
		Boolean flag = guestDao.addBook(guestTitle,guestContent,userName,timeCreated);
		return flag;
	}

	//获得所有留言
	@Override
	public List<Guest> guestAllList() {
		GuestDao guestDao =new GuestDaoImpl();
		List<Guest> guestlist = guestDao.guestAllList();
		return guestlist;
	}

	//删除留言
	@Override
	public Boolean deleteGuest(String guestId) {
		GuestDao guestDao =new GuestDaoImpl();
		boolean flag = false;
		flag = guestDao.deleteGuest(guestId);
		return flag;
	}

	//修改留言
	@Override
	public Boolean modifyGuest(String id, String replyContent) {
		GuestDao guestDao =new GuestDaoImpl();
		boolean flag = false;
		flag = guestDao.modifyGuest(id,replyContent);
		return flag;
	}

	//获得留言详情
	@Override
	public Guest getGuestView(String id) {
		GuestDao guestDao =new GuestDaoImpl();
		return guestDao.getGuestView(id);
	}
	
	//获得留言总数
		@Override
		public Integer getIndex() {
			GuestDao guestDao =new GuestDaoImpl();
			return guestDao.getIndex();
		}

}
