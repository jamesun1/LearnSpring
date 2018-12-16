package com.sunxu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "data_source_pro")
public class DataSourcePro implements Serializable {
	@Id
	private Long id;

	private String issue;

	private Date drawTime;

	private String originalCode;

	private String first;

	private String second;

	private String third;

	private String forth;

	private String fivth;

	private Date timestamp;
	
	private Date createDate;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Transient
	private String[] splitCode;

	public String[] getSplitCode() {
		return splitCode;
	}

	public void setSplitCode(String[] splitCode) {
		this.splitCode = splitCode;
	}

	private static final long serialVersionUID = 1L;

	public DataSourcePro(Long id, String issue, Date drawTime, String originalCode, String first, String second,
			String third, String forth, String fivth, Date timestamp) {
		this.id = id;
		this.issue = issue;
		this.drawTime = drawTime;
		this.originalCode = originalCode;
		this.first = first;
		this.second = second;
		this.third = third;
		this.forth = forth;
		this.fivth = fivth;
		this.timestamp = timestamp;
	}

	public DataSourcePro() {
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

	public Date getDrawTime() {
		return drawTime;
	}

	public void setDrawTime(Date drawTime) {
		this.drawTime = drawTime;
	}

	public String getOriginalCode() {
		return originalCode;
	}

	public void setOriginalCode(String originalCode) {
		this.originalCode = originalCode == null ? null : originalCode.trim();
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first == null ? null : first.trim();
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second == null ? null : second.trim();
	}

	public String getThird() {
		return third;
	}

	public void setThird(String third) {
		this.third = third == null ? null : third.trim();
	}

	public String getForth() {
		return forth;
	}

	public void setForth(String forth) {
		this.forth = forth == null ? null : forth.trim();
	}

	public String getFivth() {
		return fivth;
	}

	public void setFivth(String fivth) {
		this.fivth = fivth == null ? null : fivth.trim();
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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
		DataSourcePro other = (DataSourcePro) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getIssue() == null ? other.getIssue() == null : this.getIssue().equals(other.getIssue()))
				&& (this.getDrawTime() == null ? other.getDrawTime() == null
						: this.getDrawTime().equals(other.getDrawTime()))
				&& (this.getOriginalCode() == null ? other.getOriginalCode() == null
						: this.getOriginalCode().equals(other.getOriginalCode()))
				&& (this.getFirst() == null ? other.getFirst() == null : this.getFirst().equals(other.getFirst()))
				&& (this.getSecond() == null ? other.getSecond() == null : this.getSecond().equals(other.getSecond()))
				&& (this.getThird() == null ? other.getThird() == null : this.getThird().equals(other.getThird()))
				&& (this.getForth() == null ? other.getForth() == null : this.getForth().equals(other.getForth()))
				&& (this.getFivth() == null ? other.getFivth() == null : this.getFivth().equals(other.getFivth()))
				&& (this.getTimestamp() == null ? other.getTimestamp() == null
						: this.getTimestamp().equals(other.getTimestamp()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getIssue() == null) ? 0 : getIssue().hashCode());
		result = prime * result + ((getDrawTime() == null) ? 0 : getDrawTime().hashCode());
		result = prime * result + ((getOriginalCode() == null) ? 0 : getOriginalCode().hashCode());
		result = prime * result + ((getFirst() == null) ? 0 : getFirst().hashCode());
		result = prime * result + ((getSecond() == null) ? 0 : getSecond().hashCode());
		result = prime * result + ((getThird() == null) ? 0 : getThird().hashCode());
		result = prime * result + ((getForth() == null) ? 0 : getForth().hashCode());
		result = prime * result + ((getFivth() == null) ? 0 : getFivth().hashCode());
		result = prime * result + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
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
		sb.append(", drawTime=").append(drawTime);
		sb.append(", originalCode=").append(originalCode);
		sb.append(", first=").append(first);
		sb.append(", second=").append(second);
		sb.append(", third=").append(third);
		sb.append(", forth=").append(forth);
		sb.append(", fivth=").append(fivth);
		sb.append(", timestamp=").append(timestamp);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}