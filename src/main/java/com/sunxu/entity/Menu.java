package com.sunxu.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "menu")
public class Menu implements Serializable {
	@Id
	private String menuId;

	private String menuName;

	private String menuPath;

	private String menuUrl;

	private String icon;

	private String orders;

	private String parentId;

	private String createBy;

	private Date createDate;

	private static final long serialVersionUID = 1L;

	public Menu(String menuId, String menuName, String menuPath, String menuUrl, String icon, String orders,
			String parentId, String createBy, Date createDate) {
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuPath = menuPath;
		this.menuUrl = menuUrl;
		this.icon = icon;
		this.orders = orders;
		this.parentId = parentId;
		this.createBy = createBy;
		this.createDate = createDate;
	}

	public Menu() {
		super();
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId == null ? null : menuId.trim();
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName == null ? null : menuName.trim();
	}

	public String getMenuPath() {
		return menuPath;
	}

	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath == null ? null : menuPath.trim();
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl == null ? null : menuUrl.trim();
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	public String getOrders() {
		return orders;
	}

	public void setOrders(String orders) {
		this.orders = orders == null ? null : orders.trim();
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId == null ? null : parentId.trim();
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		Menu other = (Menu) that;
		return (this.getMenuId() == null ? other.getMenuId() == null : this.getMenuId().equals(other.getMenuId()))
				&& (this.getMenuName() == null ? other.getMenuName() == null
						: this.getMenuName().equals(other.getMenuName()))
				&& (this.getMenuPath() == null ? other.getMenuPath() == null
						: this.getMenuPath().equals(other.getMenuPath()))
				&& (this.getMenuUrl() == null ? other.getMenuUrl() == null
						: this.getMenuUrl().equals(other.getMenuUrl()))
				&& (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
				&& (this.getOrders() == null ? other.getOrders() == null : this.getOrders().equals(other.getOrders()))
				&& (this.getParentId() == null ? other.getParentId() == null
						: this.getParentId().equals(other.getParentId()))
				&& (this.getCreateBy() == null ? other.getCreateBy() == null
						: this.getCreateBy().equals(other.getCreateBy()))
				&& (this.getCreateDate() == null ? other.getCreateDate() == null
						: this.getCreateDate().equals(other.getCreateDate()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getMenuId() == null) ? 0 : getMenuId().hashCode());
		result = prime * result + ((getMenuName() == null) ? 0 : getMenuName().hashCode());
		result = prime * result + ((getMenuPath() == null) ? 0 : getMenuPath().hashCode());
		result = prime * result + ((getMenuUrl() == null) ? 0 : getMenuUrl().hashCode());
		result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
		result = prime * result + ((getOrders() == null) ? 0 : getOrders().hashCode());
		result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
		result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
		result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", menuId=").append(menuId);
		sb.append(", menuName=").append(menuName);
		sb.append(", menuPath=").append(menuPath);
		sb.append(", menuUrl=").append(menuUrl);
		sb.append(", icon=").append(icon);
		sb.append(", orders=").append(orders);
		sb.append(", parentId=").append(parentId);
		sb.append(", createBy=").append(createBy);
		sb.append(", createDate=").append(createDate);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}