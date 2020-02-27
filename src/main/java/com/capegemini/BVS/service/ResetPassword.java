package com.capegemini.BVS.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.capegemini.BVS.dto.LoginDto;
import com.capegemini.BVS.exe.BackgroundVerificationController;

public class ResetPassword {
	public void resetPassword() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the Employee Id");
		int id = scn.nextInt();
		File logfile = new File("C:\\Users\\user\\Documents\\workspace-sts-3.9.9.RELEASE\\Rahul Kumar\\BackgroundVerificationSystem\\src\\main\\resources\\login.txt");
		FileInputStream fis=null;
		HashMap<Integer, LoginDto> object1=null;
		FileOutputStream fos=null;
		LoginDto valid =null;
		try {
			fis = new FileInputStream(logfile);
			
			ObjectInputStream in = new ObjectInputStream(fis);
			
			object1 = (HashMap<Integer, LoginDto>)in.readObject();
			
			for (Map.Entry mapElement : object1.entrySet()) {
				LoginDto log = (LoginDto)mapElement.getValue();
				if(log.getEmpId()==id) {
					valid =log;
					break;
				}
			}		
			
			System.out.println("Enter the password");
			String pass = scn.next();
			valid.setPassword(pass);
			object1.put(valid.getEmpId(), valid);
			
			in.close();
			fis.close();
			fos = new FileOutputStream(logfile); 
			ObjectOutputStream out = new ObjectOutputStream(fos); 
            
          // Method for serialization of object 
          out.writeObject(object1); 
            
          out.close(); 
          fos.close(); 
          new BackgroundVerificationController().logging();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
