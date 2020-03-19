package com.capg.BVS.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.capg.BVS.controller.LoginService;
import com.capg.BVS.controller.ResetPassword;
import com.capg.BVS.model.EmployeeDocument;
import com.capg.BVS.model.LoginDto;


public class BackgroundVerificationController {
	Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("                      Background Verification System                                      ");
		System.out.println("------------------------------------------------------------------------------------------");
		new LoginService().ed();
		new BackgroundVerificationController().logging();
		
//		File logfile = new File("C:\\Users\\rahul\\OneDrive\\Documents\\Rahul Kumar\\BackgroundVerificationSystem\\src\\main\\resources\\doc.txt");
//		FileOutputStream fos=null;
//		HashMap<Integer, ArrayList<EmployeeDocument>> hash = new HashMap<Integer, ArrayList<EmployeeDocument>>();
//		ArrayList<EmployeeDocument> list = new ArrayList<EmployeeDocument>();
//		
//		try {
//			fos = new FileOutputStream(logfile); 
//            ObjectOutputStream out = new ObjectOutputStream(fos); 
//              
//            // Method for serialization of object 
//            out.writeObject(hash); 
//              
//            out.close(); 
//            fos.close(); 
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("Done");
//		
//		
	}
	
	public void logging() {
			int x= 0;
			
			System.out.println("1. Login ");
			System.out.println("2. Forget Password");
			System.out.println("3. Exit");
			try {
			x = scn.nextInt();
			}catch(Exception e) {
				System.out.println("Inputs are not appropriate");
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.println("Login Again");
				System.out.println("-------------------------------------------------------------------------------------");
				new BackgroundVerificationController().logging();
			}
			if(x==1) {
				try {
				System.out.println("Enter the EmpId");
				int empId = scn.nextInt();
				System.out.println("Enter the Password");
				String password = scn.next();
				LoginDto ldto = new LoginDto(empId, password);
				LoginService log = new LoginService();
				log.login(ldto);
				}
				catch(Exception e) {
					System.out.println("Inputs are not appropriate");
					System.out.println("-------------------------------------------------------------------------------------");
					System.out.println("Login Again");
					System.out.println("-------------------------------------------------------------------------------------");
					new BackgroundVerificationController().logging();
				}
			}
			else if(x==2){
				new ResetPassword().resetPassword();
			}
			else if (x==3){
				System.out.println("Exited");
				System.exit(0);
			}
			else {
				System.out.println("Wrong intput");
				System.out.println("Login Again");
				System.out.println("-------------------------------------------------------------------------------------");
				new BackgroundVerificationController().logging();
			}
	}
}
