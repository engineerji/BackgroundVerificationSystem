package com.capg.BVS.controller;

import java.awt.DisplayMode;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.capg.BVS.model.EmployeeDocument;
import com.capg.BVS.model.LoginDto;
import com.capg.BVS.ui.BackgroundVerificationController;
import com.capgemini.BVS.dao.FileDao;
import com.capgemini.BVS.display.Display;
import com.capgemini.BVS.serviceimpl.LoginImplementation;

public class LoginService {
	public void ed() {
		File logfile = new File("C:\\Users\\rahul\\OneDrive\\Documents\\Rahul Kumar\\BackgroundVerificationSystem2\\src\\main\\resources\\login.txt");
		FileOutputStream fos=null;
		FileInputStream fis =null;
		HashMap<Integer, LoginDto> object2=null;
		HashMap<Integer, LoginDto> hash = new HashMap<Integer, LoginDto>();
		LoginDto log1 = new LoginDto(1,"rahul@123");
		LoginDto log2 = new LoginDto(2,"kapil@123");
		LoginDto log3 = new LoginDto(3,"rtvik@123");
		LoginDto log4 = new LoginDto(4,"prince@123");
		hash.put(log1.getEmpId(), log1);
		hash.put(log2.getEmpId(), log2);
		hash.put(log3.getEmpId(), log3);
		hash.put(log4.getEmpId(), log4);
		try {
			
			ObjectOutputStream out = new FileDao().setLoginData();
              
            // Method for serialization of object 
            out.writeObject(hash); 
              
            out.close(); 
          
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}
		
	public void login(LoginDto login) {
		System.out.println("------------------------------------------------------------------------------------------");
		Scanner scn = new Scanner(System.in);
		HashMap<Integer, LoginDto> object1=null;
		int valid =0;
		try {
			
			ObjectInputStream in = new FileDao().getLoginData();
			
			object1 = ((HashMap<Integer, LoginDto>)in.readObject());
				LoginDto log = (LoginDto)object1.get(login.getEmpId());
				if(log==null) {
					System.out.println("Wrong EmplyeeId or Password or Role Id");
					new BackgroundVerificationController().logging();
				}
				System.out.println(log.getEmpId());
				if(log.getEmpId()==login.getEmpId() && (log.getPassword().equals(login.getPassword())) ) {
					//valid =log.getRoleId();
					if(log.getEmpId()==1) {
						System.out.println("Logged in as Admin");
						System.out.println("-----------------------------------------------------------------------------------");
						new LoginImplementation().AdminLogin(login);
						
					}
					else
					{
						System.out.println("Logged in as Employee");
						System.out.println("-----------------------------------------------------------------------------------");
						new LoginImplementation().EmpLogin(login);
						
					}
					
				}
				else {
					System.out.println("Wrong EmplyeeId or Password or Role Id");
					new BackgroundVerificationController().logging();
				}
	
				in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}
}
