package com.hcl.bank;

import java.util.Scanner;

public class DepositAccountMain {
public static void main(String[] args) {
	int accountNo,depositAmount;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter AccoutNo: " );
	accountNo=sc.nextInt();
	System.out.println("Enter deposit amount: ");
	depositAmount=sc.nextInt();
	AccountDAO dao=new AccountDAO();
	System.out.println(dao.depositAccount(accountNo, depositAmount));
}
}
