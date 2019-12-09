package com.hcl.bank;

import java.util.Scanner;

public class SearchAccountMain {
public static void main(String[] args) {
	int accountNo;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter AccountNo :- ");
	accountNo=sc.nextInt();
	AccountDAO dao=new AccountDAO();
	Account account=dao.searchAccount(accountNo);
	if(account!=null){
		System.out.println("First Name " + account.getFirstName());
		System.out.println("Last Name " + account.getLastName());
		System.out.println("City " + account.getCity());
		System.out.println("State " + account.getState());
		System.out.println("Amount " + account.getAmount());
		System.out.println("CheqFacil " + account.getCheqFacil());
		System.out.println("AccountType " + account.getAccountType());
		
		
		
	}else{
		System.out.println("AccountNo NOT Found!!....");
	}
}
}
