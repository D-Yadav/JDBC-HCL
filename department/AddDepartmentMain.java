package com.hcl.department;

import java.util.Scanner;

public class AddDepartmentMain {
	public static void main(String[] args) {
		DepartmentDAO dao=new DepartmentDAO();
		System.out.println(dao.generateDepartmentno());
		Department department=new Department();
		int Deptno=dao.generateDepartmentno();
		department.setDeptno(Deptno);
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Department name");
		department.setDname(sc.nextLine());
		System.out.println("Enter loc");
		department.setLoc(sc.nextLine());
        System.out.println("enter city");
        department.setCity(sc.nextLine());
        System.out.println("enter head");
        department.setHead(sc.nextLine());
        System.out.println(dao.addDepartment(department));
		
		
		
	}

}

