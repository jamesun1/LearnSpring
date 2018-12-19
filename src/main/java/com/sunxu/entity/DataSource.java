package com.sunxu.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "data_source")
public class DataSource implements Serializable {
	@Id
	private Long id;

	private String name;

	private String displayName;

	private String issue;

	private String result;

	private String figure;

	private Date publishTime;

	private String nextissue;

	private Date nexttime;

	private Integer categoryId;

	private String missed;

	private Date currenttime;

	private Date createtime;

	private String first;

	private String second;

	private String third;

	private String forth;

	private String fifth;

	@Transient
	private Date timestamp;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public String getThird() {
		return third;
	}

	public void setThird(String third) {
		this.third = third;
	}

	public String getForth() {
		return forth;
	}

	public void setForth(String forth) {
		this.forth = forth;
	}

	public String getFifth() {
		return fifth;
	}

	public void setFifth(String fifth) {
		this.fifth = fifth;
	}

	private static final long serialVersionUID = 1L;

	public DataSource(Long id, String name, String displayName, String issue, String result, String figure,
			Date publishTime, String nextissue, Date nexttime, Integer categoryId, String missed, Date currenttime,
			Date createtime) {
		this.id = id;
		this.name = name;
		this.displayName = displayName;
		this.issue = issue;
		this.result = result;
		this.figure = figure;
		this.publishTime = publishTime;
		this.nextissue = nextissue;
		this.nexttime = nexttime;
		this.categoryId = categoryId;
		this.missed = missed;
		this.currenttime = currenttime;
		this.createtime = createtime;
	}

	public DataSource() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName == null ? null : displayName.trim();
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue == null ? null : issue.trim();
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result == null ? null : result.trim();
	}

	public String getFigure() {
		return figure;
	}

	public void setFigure(String figure) {
		this.figure = figure == null ? null : figure.trim();
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getNextissue() {
		return nextissue;
	}

	public void setNextissue(String nextissue) {
		this.nextissue = nextissue == null ? null : nextissue.trim();
	}

	public Date getNexttime() {
		return nexttime;
	}

	public void setNexttime(Date nexttime) {
		this.nexttime = nexttime;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getMissed() {
		return missed;
	}

	public void setMissed(String missed) {
		this.missed = missed == null ? null : missed.trim();
	}

	public Date getCurrenttime() {
		return currenttime;
	}

	public void setCurrenttime(Date currenttime) {
		this.currenttime = currenttime;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
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
		DataSource other = (DataSource) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
				&& (this.getDisplayName() == null ? other.getDisplayName() == null
						: this.getDisplayName().equals(other.getDisplayName()))
				&& (this.getIssue() == null ? other.getIssue() == null : this.getIssue().equals(other.getIssue()))
				&& (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
				&& (this.getFigure() == null ? other.getFigure() == null : this.getFigure().equals(other.getFigure()))
				&& (this.getPublishTime() == null ? other.getPublishTime() == null
						: this.getPublishTime().equals(other.getPublishTime()))
				&& (this.getNextissue() == null ? other.getNextissue() == null
						: this.getNextissue().equals(other.getNextissue()))
				&& (this.getNexttime() == null ? other.getNexttime() == null
						: this.getNexttime().equals(other.getNexttime()))
				&& (this.getCategoryId() == null ? other.getCategoryId() == null
						: this.getCategoryId().equals(other.getCategoryId()))
				&& (this.getMissed() == null ? other.getMissed() == null : this.getMissed().equals(other.getMissed()))
				&& (this.getCurrenttime() == null ? other.getCurrenttime() == null
						: this.getCurrenttime().equals(other.getCurrenttime()))
				&& (this.getCreatetime() == null ? other.getCreatetime() == null
						: this.getCreatetime().equals(other.getCreatetime()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getDisplayName() == null) ? 0 : getDisplayName().hashCode());
		result = prime * result + ((getIssue() == null) ? 0 : getIssue().hashCode());
		result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
		result = prime * result + ((getFigure() == null) ? 0 : getFigure().hashCode());
		result = prime * result + ((getPublishTime() == null) ? 0 : getPublishTime().hashCode());
		result = prime * result + ((getNextissue() == null) ? 0 : getNextissue().hashCode());
		result = prime * result + ((getNexttime() == null) ? 0 : getNexttime().hashCode());
		result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
		result = prime * result + ((getMissed() == null) ? 0 : getMissed().hashCode());
		result = prime * result + ((getCurrenttime() == null) ? 0 : getCurrenttime().hashCode());
		result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", name=").append(name);
		sb.append(", displayName=").append(displayName);
		sb.append(", issue=").append(issue);
		sb.append(", result=").append(result);
		sb.append(", figure=").append(figure);
		sb.append(", publishTime=").append(publishTime);
		sb.append(", nextissue=").append(nextissue);
		sb.append(", nexttime=").append(nexttime);
		sb.append(", categoryId=").append(categoryId);
		sb.append(", missed=").append(missed);
		sb.append(", currenttime=").append(currenttime);
		sb.append(", createtime=").append(createtime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}