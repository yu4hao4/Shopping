package com.service;

import java.util.List;


import com.entity.Guest;

public interface GuestService {
	List<Guest> guestList(int yeshu);
	Boolean addBook(String guestTitle,String guestContent, String userName, String timeCreated);
	List<Guest> guestAllList();
	Boolean deleteGuest(String guestId);
	Boolean modifyGuest(String id, String replyContent);
	Guest getGuestView(String id);
	Integer getIndex();
}
