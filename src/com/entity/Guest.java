package com.entity;

import java.util.Date;

public class Guest {
	private Integer guestId;
	private String guestTitle;
	private String guestContent;
	private Date timeCreated;
	private String userName;
	private String reply;
	public Integer getGuestId() {
		return guestId;
	}
	public void setGuestId(Integer guestId) {
		this.guestId = guestId;
	}
	public String getGuestTitle() {
		return guestTitle;
	}
	public void setGuestTitle(String guestTitle) {
		this.guestTitle = guestTitle;
	}
	public String getGuestContent() {
		return guestContent;
	}
	public void setGuestContent(String guestContent) {
		this.guestContent = guestContent;
	}
	public Date getTimeCreated() {
		return timeCreated;
	}
	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
}
