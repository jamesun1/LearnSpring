package com.sunxu.vo;

import java.util.List;

import com.sunxu.entity.Menu;

public class MenuVo extends Menu {

	private static final long serialVersionUID = 1L;

	private List<Menu> menuList;
	
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

}
