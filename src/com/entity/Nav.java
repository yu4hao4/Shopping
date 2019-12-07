package com.entity;

public class Nav {
	private Integer navId; //栏目ID 主键 自增
	private String navName; //栏目名称
	private Integer isBelong; //所属大栏目
	public Integer getNavId() {
		return navId;
	}
	public void setNavId(Integer navId) {
		this.navId = navId;
	}
	public String getNavName() {
		return navName;
	}
	public void setNavName(String navName) {
		this.navName = navName;
	}
	public Integer getIsBelong() {
		return isBelong;
	}
	public void setIsBelong(Integer isBelong) {
		this.isBelong = isBelong;
	}
}
