package com.capgemini.BVS.serviceimpl;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.capg.BVS.controller.BcgService;
import com.capg.BVS.controller.EmployeeService;
import com.capg.BVS.model.EmployeeDocument;
import com.capg.BVS.model.LoginDto;
import com.capgemini.BVS.dao.FileDao;
import com.capgemini.BVS.display.Display;

public class LoginImplementation {
	Scanner scn = new Scanner(System.in);
	
	public void AdminLogin(LoginDto login) {
		BcgService bcg = new BcgService();
		System.out.println();
		System.out.println("List of employee who have uploaded the document :");
		new Display().display();
		System.out.println("Enter the id of which you want verify the document");
		int id=0;
		try {
			id = scn.nextInt();
		}catch(Exception e) {
			System.out.println("Input should be numeric type");
			new LoginImplementation().AdminLogin(login);
			
		}
		
		HashMap<Integer, ArrayList<EmployeeDocument>> hash=null;
		ArrayList<EmployeeDocument> list=null;
		try {
		ObjectInputStream ois =new FileDao().getDocData();
		hash = (HashMap<Integer, ArrayList<EmployeeDocument>>)ois.readObject();
		list = hash.get(id);
		//System.out.println(list);
		}catch(Exception e) {
			System.out.println("no");
		}
		
		if(list==null) {
			System.out.println("No data is present ");
			new LoginImplementation().AdminLogin(login);
		}
		new Display().display1(list);
		System.out.println();
		System.out.println("Enter the id of document want to verify");
		int id2 = 0;
		try {
			id2 = scn.nextInt();
		}catch(Exception e) {
			System.out.println("Input should be numeric type");
			new LoginImplementation().AdminLogin(login);
			
		}
		
		EmployeeDocument dto=bcg.getDocument(list,id2);
		if(dto==null) {
			new LoginImplementation().AdminLogin(login);
		}
		new Display().display2(dto);
		System.out.println("Enter 1 for reject and 2 for accept :");
		
		int choice = 0;
		try {
			choice = scn.nextInt();
		} catch (Exception e) {
			System.out.println("Please input numeric value appropriately");
			//new BcgService().getDocument(id);
		}
		if(choice==2) {
			new BcgService().approveStatus(list,id2);
		}
		else if(choice == 1)
		{
			new BcgService().rejectStatus(list,id2);
		}
		else {
			System.out.println("Input is not appropriate");
			//new BcgService().getDocument(id);
		}
	}
	
	
	
	
	public void EmpLogin(LoginDto login) {
		System.out.print("What you want to do: \n1.status\n2.store\n");
		int choice=0;
		try {
			choice = scn.nextInt();
		}catch(Exception e) {
			System.out.println("Input should be numeric");
			new LoginImplementation().EmpLogin(login);
		}
		
		if(choice==1) {
			new EmployeeService().viewStatus(login.getEmpId());
		}
		else if(choice ==2){
			new EmployeeService().storeDocument(login);
		}
		else {
			System.out.println("Invalid choice");
			new LoginImplementation().EmpLogin(login);
		}
		System.out.println("------------------------------------------------------------------------------------------------------------");
	}
}
