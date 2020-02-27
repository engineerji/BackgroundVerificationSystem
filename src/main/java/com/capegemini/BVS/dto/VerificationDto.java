package com.capegemini.BVS.dto;

import java.io.Serializable;
import java.util.Date;

public class VerificationDto implements Serializable{
	private int verId;
	private Date startDate;
	private Date endDate;
	private String status;	
	
	public VerificationDto(int verId, Date startDate, Date endDate, String status) {
		super();
		this.verId = verId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}
	
	public int getVerId() {
		return verId;
	}
	public void setVerId(int verId) {
		this.verId = verId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "VerificationDto [verId=" + verId + ", startDate=" + startDate + ", endDate=" + endDate + ", status="
				+ status + "]";
	}
	
}
