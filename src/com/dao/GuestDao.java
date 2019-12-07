package com.dao;

import java.util.List;

import com.entity.Guest;

public interface GuestDao {
	List<Guest> guestList(int id);
	Boolean addBook(String guestTitle, String guestContent, String userName, String timeCreated);
	List<Guest> guestAllList();
	Boolean deleteGuest(String guestId);
	Boolean modifyGuest(String id, String replyContent);
	Guest getGuestView(String id);
	Integer getIndex();
}
