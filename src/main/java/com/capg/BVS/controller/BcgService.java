package com.capg.BVS.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.capg.BVS.model.EmployeeDocument;
import com.capg.BVS.model.VerificationDto;
import com.capg.BVS.ui.BackgroundVerificationController;
import com.capgemini.BVS.dao.FileDao;
import com.capgemini.BVS.serviceimpl.LoginImplementation;

public class BcgService {
	public List<EmployeeDocument> getById(int id) {
		System.out.println("------------------------------------------------------------------------------------------");
		HashMap<Integer, ArrayList<EmployeeDocument>> object1=null;
		ArrayList<EmployeeDocument> list = null;
		try {
			
			ObjectInputStream in = new FileDao().getDocData();
			
			object1 = (HashMap<Integer, ArrayList<EmployeeDocument>>)in.readObject();
			
			if(object1==null) {
				System.out.println("No information stored");
				System.out.println("------------------------------------------------------------------------------------------");
				new BackgroundVerificationController().logging();
			}
			else {
				list =object1.get(id);
				if(list==null) {
					System.out.println("No information Stored");
					new BackgroundVerificationController().logging();
				}
			}
			
			
			in.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public void approveStatus(ArrayList<EmployeeDocument> list,int id) {
		System.out.println("------------------------------------------------------------------------------------------");
		HashMap<Integer, ArrayList<EmployeeDocument>> object1=null;
		try {

			
			ObjectInputStream in = new FileDao().getDocData();
			
			object1 = (HashMap<Integer, ArrayList<EmployeeDocument>>)in.readObject();
			
			//EmployeeDocumentDto object = (EmployeeDocumentDto)object1.get(id);
			for(EmployeeDocument das:list) {
				if(das.getDocId()==id) {
					VerificationDto dto=das.getVerificationDto();
					dto.setStatus("Accepted");
					object1.put(das.getEmpId(),list);
				}
			}
			//System.out.println(list);
			
//			object.setVerificationDto(doc);
//			object1.put(id, object);
			in.close();


			ObjectOutputStream out = new FileDao().setDocData();
			out.writeObject(object1);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Accepted");
		System.out.println("------------------------------------------------------------------------------------------");
		new BackgroundVerificationController().logging();
	}
	
	
	public EmployeeDocument getDocument(ArrayList<EmployeeDocument> list, int id) {
		Scanner scn = new Scanner(System.in);
		System.out.println("------------------------------------------------------------------------------------------");
		EmployeeDocument data = null;
		try {
			
			for(EmployeeDocument emp :list) {
				if(emp.getDocId()==id) {
					data=emp;
					break;
				}
				else {
					System.out.println("No such data is stored");
					break;
					//new LoginImplementation().AdminLogin(login);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return data;
		
	}
	public void rejectStatus(ArrayList<EmployeeDocument> list,int id) {
		System.out.println("------------------------------------------------------------------------------------------");
		HashMap<Integer, ArrayList<EmployeeDocument>> object1=null;
		try {

			
			ObjectInputStream in = new FileDao().getDocData();
			
			object1 = (HashMap<Integer, ArrayList<EmployeeDocument>>)in.readObject();
			
			//EmployeeDocumentDto object = (EmployeeDocumentDto)object1.get(id);
			for(EmployeeDocument das:list) {
				if(das.getDocId()==id) {
					VerificationDto dto=das.getVerificationDto();
					dto.setStatus("Rejected");
					object1.put(das.getEmpId(),list);
				}
			}
			//System.out.println(list);
			
//			object.setVerificationDto(doc);
//			object1.put(id, object);
			in.close();


			ObjectOutputStream out = new FileDao().setDocData();
			out.writeObject(object1);
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Rejected");
		System.out.println("------------------------------------------------------------------------------------------");
		new BackgroundVerificationController().logging();
	}
}
