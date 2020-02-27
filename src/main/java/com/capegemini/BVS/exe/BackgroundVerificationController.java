package com.capegemini.BVS.exe;

import java.util.Scanner;

import com.capegemini.BVS.dto.LoginDto;
import com.capegemini.BVS.service.LoginService;
import com.capegemini.BVS.service.ResetPassword;

public class BackgroundVerificationController {
	Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		new BackgroundVerificationController().logging();
	}
	
	public void logging() {
			int x= 0;
			
			System.out.println("1. Login ");
			System.out.println("2. Forget Password");
			x = scn.nextInt();
			if(x==1) {
				System.out.println("Enter the EmpId");
				int empId = scn.nextInt();
				System.out.println("Enter the Password");
				String password = scn.next();
				System.out.println("Enter the RoleId 1. Admin\n2. Employee");
				int roleId = scn.nextInt();
				LoginDto ldto = new LoginDto(empId, password, roleId);
				LoginService log = new LoginService();
				log.login(ldto);
			}
			else if(x==2){
				new ResetPassword().resetPassword();
			}
//			else {
//				System.out.println("Enter valid Choice");
//			}
	}
}
