package com.capgemini.BVS.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.capg.BVS.model.EmployeeDocument;
import com.capg.BVS.model.VerificationDto;
import com.capg.BVS.ui.BackgroundVerificationController;


public class FileDao {
	public ObjectInputStream getLoginData() {
		File logfile = new File("C:\\Users\\rahul\\OneDrive\\Documents\\Rahul Kumar\\BackgroundVerificationSystem\\src\\main\\resources\\login.txt");
		FileInputStream fis=null;
		ObjectInputStream in= null;
		try {
			fis = new FileInputStream(logfile);
			
			in = new ObjectInputStream(fis);
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		//System.out.println("return get");
		return in;
	}
	
	public ObjectOutputStream setLoginData() {
		File logfile = new File("C:\\Users\\rahul\\OneDrive\\Documents\\Rahul Kumar\\BackgroundVerificationSystem\\src\\main\\resources\\login.txt");
		FileOutputStream fos=null;
		ObjectOutputStream out =null;
		try {
			fos = new FileOutputStream(logfile);
			out= new ObjectOutputStream(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("return set");
		return out;
	}
	
	
	public ObjectInputStream getDocData() {
		File logfile = new File("C:\\Users\\rahul\\OneDrive\\Documents\\Rahul Kumar\\BackgroundVerificationSystem\\src\\main\\resources\\doc.txt");
		FileInputStream fis=null;
		HashMap<Integer, EmployeeDocument> object1=null;
		ObjectInputStream in=null;
		try {
			fis = new FileInputStream(logfile);
			
			in = new ObjectInputStream(fis);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return in;
	}
	
	public ObjectOutputStream setDocData() {
		File logfile = new File("C:\\Users\\rahul\\OneDrive\\Documents\\Rahul Kumar\\BackgroundVerificationSystem\\src\\main\\resources\\doc.txt");
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(logfile);
			out = new ObjectOutputStream(fos);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return out;
	}
}
