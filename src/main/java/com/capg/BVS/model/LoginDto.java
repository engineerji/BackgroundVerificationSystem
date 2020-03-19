package com.capg.BVS.model;

import java.io.Serializable;

public class LoginDto implements Serializable{

	private int empId;
	private String  password;
//	private int roleId;
	
	public LoginDto(int empId, String password) {
		super();
		this.empId = empId;
		this.password = password;
//		this.roleId = roleId;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public int getRoleId() {
//		return roleId;
//	}
//	public void setRoleId(int roleId) {
//		this.roleId = roleId;
//	}

	@Override
	public String toString() {
		return "LoginDto [empId=" + empId + ", password=" + password +"]";
	}
	
}
