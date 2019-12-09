package com.hcl.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {

Connection connection;
PreparedStatement pst;

public String withdrawAccount(int accountNo,int withdrawAmount){
	connection=DaoConnection.getConnection();
	String result="";
	Account account =searchAccount(accountNo);
	if(account!=null){
		int amount=account.getAmount();
		if(amount-withdrawAmount >= 1000){
			String cmd="Update Accounts set Amount=Amount- ? Where AccountNo=?";
			try {
				pst=connection.prepareStatement(cmd);
				pst.setInt(1, withdrawAmount);
				pst.setInt(2, accountNo);
				pst.executeUpdate();
				cmd="Insert into Trans(AccountNo, TransAmount, TransType) values(?,?,?)";
				pst=connection.prepareStatement(cmd);
				pst.setInt(1, withdrawAmount);
				pst.setInt(2, accountNo);
				pst.setString(3, "D");
				pst.executeUpdate();
				result="amount debited!...";
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			result="Insufficient Fund!!!.account..";
		}
	}else{
		result="Account Not Found!!!!....";
	}
	return result;
}
public String depositAccount(int accountNo, int depositAmount){
	connection=DaoConnection.getConnection();
	String result="";
	String cmd="Update Accounts set Amount=Amount+ ? Where AccountNo=?";

		try {
			pst=connection.prepareStatement(cmd);
			pst.setInt(1, depositAmount);
			pst.setInt(2, accountNo);
			pst.executeUpdate();
			cmd="Insert into Trans(AccountNo, TransAmount, TransType) values(?,?,?)";
			pst=connection.prepareStatement(cmd);
			pst.setInt(1, depositAmount);
			pst.setInt(2, accountNo);
			pst.setString(3, "C");
			pst.executeUpdate();
			result="amount credted!...";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	return result;
}
public String closeAccount(int accountNo){
	connection=DaoConnection.getConnection();
	String result="";
	String cmd=" update accounts set status='inactive' where accountNo=?";
	try {
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, accountNo);
		pst.executeUpdate();
		result="Account Closed!!...";
		
	} catch (SQLException e) {
		result=e.getMessage();
		e.printStackTrace();
	}
	return result;
}
public String updateAccount(int accountNo, String city, String state){
	connection=DaoConnection.getConnection();
	String result="";
	String cmd="update Accounts set City=?, State=? where AccountNo=?";
	try {
		pst=connection.prepareStatement(cmd);
		pst.setString(1, city);
		pst.setString(2, state);
		pst.setInt(3, accountNo);
		pst.executeUpdate();
		result="Accound Updated!!...";
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return cmd;
	
}

public Account searchAccount(int accountNo){
	Account account=null;
	String cmd=" Select * from Accounts where AccountNo=?";
	connection=DaoConnection.getConnection();
	try {
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, accountNo);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			account=new Account();
			account.setFirstName(rs.getString("firstName"));
			account.setLastName(rs.getString("lastName"));
			account.setCity(rs.getString("city"));
			account.setState(rs.getString("state"));
			account.setAmount(rs.getInt("amount"));
			account.setCheqFacil(rs.getString("cheqFacil"));
			account.setAccountType(rs.getString("accounttype"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return account;
}

public String CreateAccount(Account account){
	connection=DaoConnection.getConnection();
	String cmd=" insert into Accounts(AccountNo,FirstName, "
			+ " LastName,City,State,Amount,CheqFacil,"
			+ " AccountType) values(?,?,?,?,?,?,?,?)" ;
	String result=" ";
	try {
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, account.getAccountNo());
		pst.setString(2, account.getFirstName());
		pst.setString(3, account.getLastName());
		pst.setString(4, account.getCity());
		pst.setString(5, account.getState());
		pst.setInt(6, account.getAmount());
		pst.setString(7, account.getCheqFacil());
		pst.setString(8, account.getAccountType());
		pst.executeUpdate();
		result= " Account Created Successfully "
		+ account.getAccountNo();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result ;
	
}
public int generateAccountNo(){
	connection = DaoConnection.getConnection();
	String cmd=" select case when max(accountNo) IS NULL " 
	+ " THEN 1 ELSE max(AccountNO)+1 end " + " AccountNo From Accounts ";
	int accountNo=0;
	try {
		pst=connection.prepareStatement(cmd);
		ResultSet rs=pst.executeQuery();
		rs.next();
		accountNo=rs.getInt("AccountNo");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return accountNo;
}
}
