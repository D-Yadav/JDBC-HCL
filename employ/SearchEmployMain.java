package com.hcl.employ;

import java.util.Scanner;

public class SearchEmployMain {

	public static void main(String[] args) {
		int empno;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter employ no");
		empno=sc.nextInt();
		EmployDao dao=new EmployDao();
		Employ employ=dao.searchEmploy(empno);
		if(employ!=null) {
			System.out.println("name"+employ.getName());
			System.out.println("Department"+employ.getDept());
		}else {
			System.out.println("record not found");
		}
		
	}
	
}
