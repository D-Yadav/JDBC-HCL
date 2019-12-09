package com.hcl.employ;

import java.util.Scanner;

public class AddEmployMain {

	public static void main(String[] args) {
		EmployDao dao=new EmployDao();
		System.out.println(dao.generateEmployno());
		Employ employ=new Employ();
		int empno=dao.generateEmployno();
		employ.setEmpno(empno);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter employ name");
		employ.setName(sc.nextLine());
		System.out.println("enter department");
		employ.setDept(sc.nextLine());
		System.out.println("enter designation");
		employ.setDesig(sc.nextLine());
		System.out.println("enter salary");
		employ.setBasic(Integer.parseInt(sc.nextLine()));
		System.out.println(dao.addEmploy(employ));
		
		
	}
	
}
