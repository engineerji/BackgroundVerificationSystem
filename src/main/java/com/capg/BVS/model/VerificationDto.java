package com.capg.BVS.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class VerificationDto implements Serializable{
	private int verId;
	private LocalDate startDate;
	private LocalDate endDate;
	private String status;	
	
	public VerificationDto(int verId, LocalDate startDate, LocalDate endDate, String status) {
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
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
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
