package com.capegemini.BVS.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.capegemini.BVS.dto.LoginDto;
import com.capegemini.BVS.exe.BackgroundVerificationController;

public class LoginService {
//	public void ed() {
//		File logfile = new File("C:\\Users\\user\\Documents\\workspace-sts-3.9.9.RELEASE\\Rahul Kumar\\BackgroundVerificationSystem\\src\\main\\resources\\login.txt");
//		FileOutputStream fos=null;
//		HashMap<Integer, LoginDto> hash = new HashMap<Integer, LoginDto>();
//		LoginDto log1 = new LoginDto(1,"rahul@123",1);
//		LoginDto log2 = new LoginDto(2,"kapil@123",2);
//		LoginDto log3 = new LoginDto(3,"rtvik@123",2);
//		LoginDto log4 = new LoginDto(4,"prince@123",2);
//		hash.put(log1.getEmpId(), log1);
//		hash.put(log2.getEmpId(), log2);
//		hash.put(log3.getEmpId(), log3);
//		hash.put(log4.getEmpId(), log4);
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
//	}
		
	public void login(LoginDto login) {
		File logfile = new File("C:\\Users\\user\\Documents\\workspace-sts-3.9.9.RELEASE\\Rahul Kumar\\BackgroundVerificationSystem\\src\\main\\resources\\login.txt");
		FileInputStream fis=null;
		HashMap<Integer, LoginDto> object1=null;
		int valid =0;
		try {
			fis = new FileInputStream(logfile);
			
			ObjectInputStream in = new ObjectInputStream(fis);
			
			object1 = (HashMap<Integer, LoginDto>)in.readObject();
			
			for (Map.Entry mapElement : object1.entrySet()) {
				LoginDto log = (LoginDto)mapElement.getValue();
				if(log.getEmpId()==login.getEmpId() && log.getPassword().equals(login.getPassword())) {
					valid =log.getRoleId();
					break;
				}
			}		
			
			if(valid==1) {
				System.out.println("Logged in as Admin");
			}
			else if(valid==2)
			{
				System.out.println("Logged in as Employee");
			}
			else {
				System.out.println("Wrong EmplyeeId and Password");
				new BackgroundVerificationController().logging();
			}
			
			in.close();
			fis.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}
}
