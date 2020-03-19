package com.capg.BVS.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.capg.BVS.model.LoginDto;
import com.capg.BVS.ui.BackgroundVerificationController;
import com.capgemini.BVS.dao.FileDao;

public class ResetPassword {
	public void resetPassword() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the Employee Id");
		int id = scn.nextInt();
		HashMap<Integer, LoginDto> object1 =null;
		LoginDto valid =null;
		try {
			
			ObjectInputStream in = new FileDao().getLoginData();
			
			object1 = (HashMap<Integer, LoginDto>)in.readObject();
			
			for (Map.Entry mapElement : object1.entrySet()) {
				LoginDto log = (LoginDto)mapElement.getValue();
				if(log.getEmpId()==id) {
					valid =log;
					break;
				}
			}		
			
			System.out.println("Enter the new password");
			String pass = scn.next();
			valid.setPassword(pass);
			object1.put(valid.getEmpId(), valid);
			//System.out.println("Put");
			in.close();
			ObjectOutputStream out = new FileDao().setLoginData(); 
            //System.out.println(object1);
          // Method for serialization of object 
          out.writeObject(object1); 
            
          out.close(); 
          new BackgroundVerificationController().logging();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
