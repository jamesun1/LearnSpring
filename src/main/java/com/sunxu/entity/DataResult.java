package com.sunxu.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "data_result")
public class DataResult implements Serializable {
	@Id
	private Long id;

	private String issue;

	private String digit;

	private String result;

	private Date createDate;

	private static final long serialVersionUID = 1L;

	public DataResult(Long id, String issue, String digit, String result, Date createDate) {
		this.id = id;
		this.issue = issue;
		this.digit = digit;
		this.result = result;
		this.createDate = createDate;
	}

	public DataResult() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue == null ? null : issue.trim();
	}

	public String getDigit() {
		return digit;
	}

	public void setDigit(String digit) {
		this.digit = digit == null ? null : digit.trim();
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result == null ? null : result.trim();
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
		DataResult other = (DataResult) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getIssue() == null ? other.getIssue() == null : this.getIssue().equals(other.getIssue()))
				&& (this.getDigit() == null ? other.getDigit() == null : this.getDigit().equals(other.getDigit()))
				&& (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
				&& (this.getCreateDate() == null ? other.getCreateDate() == null
						: this.getCreateDate().equals(other.getCreateDate()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getIssue() == null) ? 0 : getIssue().hashCode());
		result = prime * result + ((getDigit() == null) ? 0 : getDigit().hashCode());
		result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
		result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
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
		sb.append(", digit=").append(digit);
		sb.append(", result=").append(result);
		sb.append(", createDate=").append(createDate);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}