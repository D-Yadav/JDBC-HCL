package com.hcl.bank;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class AccountTest {

	static Account account=null;
	@BeforeClass
	public static void setup(){
		account =new Account();
	}
	@Test
	public void testGettersAndSetters() {
	account = new Account();
	account.setAccountNo(1);;
	account.setFirstName("Deeps");
	account.setLastName("Ydv");
	account.setCity("Delhi");
	account.setState("NCR");
	account.setAmount(50000);
	account.setCheqFacil("Yes");
	account.setAccountType("Saving");
	assertEquals(1,account.getAccountNo());
	assertEquals("Deeps",account.getFirstName());
	assertEquals("Ydv",account.getLastName());
	assertEquals("Delhi",account.getCity());
	assertEquals("NCR",account.getState());
	assertEquals(50000,account.getAmount());
	assertEquals("Yes",account.getCheqFacil());
	assertEquals("Saving",account.getAccountType());
	
	}
}
