package com.hcl.department;

import java.util.Scanner;

public class SearchDepartmentMain {
	public static void main(String[] args) {
		int Deptno;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Department no");
		Deptno=sc.nextInt();
		DepartmentDAO dao=new DepartmentDAO();
		Department department=dao.searchDepartment(Deptno);
		if(department!=null){
			System.out.println("Dname :"+department.getDname());
			System.out.println("Loc :"+department.getLoc());
		}else{
			System.out.println("Record Not Found...........");
		}
		
	}

}
