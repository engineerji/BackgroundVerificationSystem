package com.capg.BVS.controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.capg.BVS.model.EmployeeDocument;
import com.capg.BVS.model.LoginDto;
import com.capg.BVS.model.VerificationDto;
import com.capg.BVS.ui.BackgroundVerificationController;
import com.capgemini.BVS.dao.FileDao;

public class EmployeeService {
	Scanner scn = new Scanner(System.in);
	
	public void viewStatus(int empid) {
		System.out.println("------------------------------------------------------------------------------------------");
		HashMap<Integer, ArrayList<EmployeeDocument>> object1=null;
		try {
			ObjectInputStream in = new FileDao().getDocData();
			
			object1 = (HashMap<Integer, ArrayList<EmployeeDocument>>)in.readObject();
			ArrayList<EmployeeDocument> list = object1.get(empid);
			if(list!=null) {
			Iterator<EmployeeDocument> itr = list.iterator();
			while(itr.hasNext()) {
					EmployeeDocument emp =itr.next();
	//				if(emp!=null) {
						VerificationDto vDto = emp.getVerificationDto();
						if(empid==emp.getEmpId()) {
							System.out.println("Document data : "+emp.getDocData()+" Status is :"+vDto.getStatus());
	//					}
					}
	//				else {
	//					System.out.println("No Document is stored");
	//					System.out.println("------------------------------------------------------------------------------------------");
	//					new BackgroundVerificationController().logging();
	//				}
				}
			System.out.println("------------------------------------------------------------------------------------------");
			}
			else {
				System.out.println("No Document is stored");
				System.out.println("------------------------------------------------------------------------------------------");
				new BackgroundVerificationController().logging();
			}
			in.close();
			new BackgroundVerificationController().logging();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	//empName, int docId, String docType, String docData
	
	
	public void storeDocument(LoginDto logDto) {
		//System.out.println(ld.getEmpId()+""+ld.getRoleId());
		System.out.println();
		System.out.println("Enter the Employee Name :");
		String empName = scn.nextLine();
		System.out.println("Enter the Document Id :");
		int docId = scn.nextInt();
		System.out.println("Enter the Document Type\n 1. Id\n2. HSC\n3. SSC\n4. Photo");
		String docType = scn.next();
		//scn.hasNextLine();
		System.out.println("Enter the document data :");
		scn.nextLine();
		String docData = scn.nextLine();
		
		//System.out.println("Success");
		int verid = logDto.getEmpId()*10+1;
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");  
		LocalDate now = LocalDate.now();
		LocalDate tomorrow = now.plusDays(2);
	    //System.out.println(tomorrow);
		VerificationDto verifyDto = new VerificationDto(verid,now,tomorrow,"pending");
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println(verifyDto.getStatus());
	
		EmployeeDocument empDocDto = new EmployeeDocument(logDto.getEmpId(), empName, docId, docType, docData, verifyDto);
		
		
		HashMap<Integer, ArrayList<EmployeeDocument>> object1=null;
		ArrayList<EmployeeDocument> list = null;
		try {
			
			ObjectInputStream in = new FileDao().getDocData();
			
			object1 = (HashMap<Integer, ArrayList<EmployeeDocument>>)in.readObject();
			list = object1.get(logDto.getEmpId());
			if(list==null) {
				list = new ArrayList<EmployeeDocument>();
			}
			list.add(empDocDto);
			object1.put(empDocDto.getEmpId(),list);	
			
			in.close();
			ObjectOutputStream out = new FileDao().setDocData();
			out.writeObject(object1);
			
			out.close();
			System.out.println("Document stored");
			System.out.println("------------------------------------------------------------------------------------------");
			new BackgroundVerificationController().logging();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
