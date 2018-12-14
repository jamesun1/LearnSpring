package com.sunxu.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "history_info")
public class HistoryInfo implements Serializable {
	@Id
	private Integer id;

	private String issue;

	private String adviceNum;

	private String winNum;

	private String type;

	private String win;

	private Date createTime;

	private static final long serialVersionUID = 1L;

	public HistoryInfo(Integer id, String issue, String adviceNum, String winNum, String type, String win,
			Date createTime) {
		this.id = id;
		this.issue = issue;
		this.adviceNum = adviceNum;
		this.winNum = winNum;
		this.type = type;
		this.win = win;
		this.createTime = createTime;
	}

	public HistoryInfo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue == null ? null : issue.trim();
	}

	public String getAdviceNum() {
		return adviceNum;
	}

	public void setAdviceNum(String adviceNum) {
		this.adviceNum = adviceNum == null ? null : adviceNum.trim();
	}

	public String getWinNum() {
		return winNum;
	}

	public void setWinNum(String winNum) {
		this.winNum = winNum == null ? null : winNum.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getWin() {
		return win;
	}

	public void setWin(String win) {
		this.win = win == null ? null : win.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
		HistoryInfo other = (HistoryInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getIssue() == null ? other.getIssue() == null : this.getIssue().equals(other.getIssue()))
				&& (this.getAdviceNum() == null ? other.getAdviceNum() == null
						: this.getAdviceNum().equals(other.getAdviceNum()))
				&& (this.getWinNum() == null ? other.getWinNum() == null : this.getWinNum().equals(other.getWinNum()))
				&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
				&& (this.getWin() == null ? other.getWin() == null : this.getWin().equals(other.getWin()))
				&& (this.getCreateTime() == null ? other.getCreateTime() == null
						: this.getCreateTime().equals(other.getCreateTime()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getIssue() == null) ? 0 : getIssue().hashCode());
		result = prime * result + ((getAdviceNum() == null) ? 0 : getAdviceNum().hashCode());
		result = prime * result + ((getWinNum() == null) ? 0 : getWinNum().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getWin() == null) ? 0 : getWin().hashCode());
		result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", issue=").append(issue);
		sb.append(", adviceNum=").append(adviceNum);
		sb.append(", winNum=").append(winNum);
		sb.append(", type=").append(type);
		sb.append(", win=").append(win);
		sb.append(", createTime=").append(createTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}