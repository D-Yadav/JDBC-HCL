package com.hcl.employ;

import java.util.Scanner;

public class DeleteEmployMain {

	public static void main(String[] args) {
		int empno;
		System.out.println("enter employ no");
		Scanner sc=new Scanner(System.in);
		empno=sc.nextInt();
		EmployDao dao=new EmployDao();
		System.out.println(dao.deleteEmploy(empno));
	}
	
}
