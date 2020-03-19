package com.capgemini.BVS.display;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.capg.BVS.model.EmployeeDocument;
import com.capg.BVS.model.VerificationDto;
import com.capgemini.BVS.dao.FileDao;

public class Display {
	public void display1(List<EmployeeDocument> list){
		Iterator<EmployeeDocument> itr =list.iterator();
		while(itr.hasNext()) {
			EmployeeDocument emp = itr.next();
			VerificationDto veri = emp.getVerificationDto();
			System.out.println("Employee id - "+emp.getEmpId()+" Employee Name - "+emp.getEmpName()+" Employee Document id - "+emp.getDocId()+" Employee Document Data - "+emp.getDocData());
			System.out.println("Verification id - "+veri.getVerId()+" Verification Start date - "+veri.getStartDate()+" Verification End Date - "+veri.getEndDate()+" Verification Status - "+veri.getStatus());
			System.out.println();
		}
	}
	public void display2(EmployeeDocument emp){
		VerificationDto veri = emp.getVerificationDto();
		System.out.println("Employee id - "+emp.getEmpId()+" Employee Name - "+emp.getEmpName()+" Employee Document id - "+emp.getDocId()+" Employee Document Data - "+emp.getDocData());
		System.out.println("Verification id - "+veri.getVerId()+" Verification Start date - "+veri.getStartDate()+" Verification End Date - "+veri.getEndDate()+" Verification Status - "+veri.getStatus());
	}
	
	public void display() {
		try {
			
		ObjectInputStream in = new FileDao().getDocData();
		HashMap<Integer, ArrayList<EmployeeDocument>> hash = (HashMap<Integer, ArrayList<EmployeeDocument>>)in.readObject();
		
		System.out.println("------------------------------------------------------------------------------------------------------------");
		for(Map.Entry ed: hash.entrySet()) {
			ArrayList<EmployeeDocument> list = hash.get(ed.getKey());
			System.out.println("Employee Id : "+list.get(0).getEmpId()+" - "+"Employee Name : "+list.get(0).getEmpName());
			System.out.println("------------------------------------------------------------------------------------------------------------");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	public void displayList(int id) {
//		try {
//			
//			ObjectInputStream in = new FileDao().getDocData();
//			HashMap<Integer, ArrayList<EmployeeDocumentDto>> hash = (HashMap<Integer, ArrayList<EmployeeDocumentDto>>)in.readObject();
//			ArrayList<EmployeeDocumentDto> list = hash.get(id);
//			System.out.println("------------------------------------------------------------------------------------------------------------");
//			for(EmployeeDocumentDto dt : list) {
//				VerificationDto veri =dt.getVerificationDto();
//				System.out.println("Document id :"+dt.getDocId()+"Document data : "+dt.getDocData());
//				System.out.println("Verification Id"+veri.getVerId()+"  Status : "+veri.getStatus());
//			}
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//	}
}
