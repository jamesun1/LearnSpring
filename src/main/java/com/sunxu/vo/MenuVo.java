package com.sunxu.vo;

import java.util.List;

import com.sunxu.entity.Menu;

public class MenuVo extends Menu {

	private static final long serialVersionUID = 1L;

	private List<Menu> menuList;

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

}
