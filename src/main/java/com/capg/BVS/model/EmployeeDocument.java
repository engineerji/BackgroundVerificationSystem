package com.capg.BVS.model;

import java.io.Serializable;

public class EmployeeDocument implements Serializable{
	
	private int empId;
	private String empName;
	private int docId;
	private String docType;
	private String docData;
	private VerificationDto verificationDto;
	
	
	public EmployeeDocument(int empId, String empName, int docId, String docType, String docData,
			VerificationDto verificationDto) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.docId = docId;
		this.docType = docType;
		this.docData = docData;
		this.verificationDto = verificationDto;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getDocData() {
		return docData;
	}
	public void setDocData(String docData) {
		this.docData = docData;
	}
	public VerificationDto getVerificationDto() {
		return verificationDto;
	}
	public void setVerificationDto(VerificationDto verificationDto) {
		this.verificationDto = verificationDto;
	}

	@Override
	public String toString() {
		return "EmployeeDocumentDto [empId=" + empId + ", empName=" + empName + ", docId=" + docId + ", docType="
				+ docType + ", docData=" + docData + ", verificationDto=" + verificationDto + "]";
	}
	
	
}
