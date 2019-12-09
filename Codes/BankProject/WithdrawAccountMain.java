package com.hcl.bank;

import java.util.Scanner;

public class WithdrawAccountMain {
public static void main(String[] args) {
	int accountNo,withdrawAmount;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter AccoutNo: " );
	accountNo=sc.nextInt();
	System.out.println("Enter Withdraw amount: ");
	withdrawAmount=sc.nextInt();
	AccountDAO dao=new AccountDAO();
	System.out.println(dao.withdrawAccount(accountNo, withdrawAmount));
}
}
