package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Test;

public class BankAccountTest {
    @Test
    public void setAccountNumberTest(){
        BankAccount checkingAccount = new CheckingAccount("1232",12.88,"JOE","Password", 1234.00);
        String expected = "1532";
        checkingAccount.setAccountNumber(expected);
        String actual = checkingAccount.getAccountNumber();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getAccountNumberTest(){
        CheckingAccount checkingAccount = new CheckingAccount("1232",12.88,"JOE","Password", 1234.00);
        String expected= "1232";
        String actual = checkingAccount.getAccountNumber();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void setFeesTest(){
        CheckingAccount checkingAccount = new CheckingAccount("1232",12.88,"JOE","Password", 1234.00);
        double expected = 15.32;
        checkingAccount.setFees(expected);
        double actual = checkingAccount.getFees();
        Assert.assertEquals(expected, actual, 0.0);
    }
    @Test
    public void getFeesTest(){
        CheckingAccount checkingAccount = new CheckingAccount("1232",12.88,"JOE","Password", 1234.00);
        double expected = 12.88;
        double actual = checkingAccount.getFees();
        Assert.assertEquals(expected, actual, 0.0);
    }
    @Test
    public void getNameTest(){
        CheckingAccount checkingAccount = new CheckingAccount("1232",12.88,"JOE","Password", 1234.00);
        String expectedName = "JOE";
        String actualName = checkingAccount.getName();
        Assert.assertEquals(expectedName,actualName);
    }
    @Test
    public void setNameTest(){
        CheckingAccount checkingAccount = new CheckingAccount("1232",12.88,"JOE","Password", 1234.00);
        String expected = "Argent";
        checkingAccount.setName(expected);
        String actual = checkingAccount.getName();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getBalanceTest(){
        CheckingAccount checkingAccount = new CheckingAccount("1232",12.88,"JOE","Password", 1234.00);
        double expected = 1234.00;
        checkingAccount.setBalance(expected);
        double actual = checkingAccount.getBalance();
        //then
        Assert.assertEquals(expected, actual, 0.0);
    }
    @Test
    public void setBalanceTest(){
        CheckingAccount checkingAccount = new CheckingAccount("1232",12.88,"JOE","Password", 1234.00);
        double expected = 153244.28;
        checkingAccount.setBalance(expected);
        double actual = checkingAccount.getBalance();
        Assert.assertEquals(expected, actual, 0.0);
    }
}

