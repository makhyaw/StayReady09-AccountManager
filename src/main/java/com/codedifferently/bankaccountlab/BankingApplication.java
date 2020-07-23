package com.codedifferently.bankaccountlab;

import com.codedifferently.bankaccountlab.BankAccount;
import com.codedifferently.bankaccountlab.BusinessAccount;

import java.util.HashMap;
import java.util.Scanner;
import java.util.jar.JarOutputStream;
public class BankingApplication  {
    Scanner userInput = new Scanner(System.in);
    private final HashMap<String, BankAccount> accountsHashMap = new HashMap<String, BankAccount>();
    public void run() {
        System.out.println("Welcome to the ATM!");
        System.out.println("Pick a number to use the feature you would like. 1. create account, 2. view account, " +
                "3. delete account, 4. exit");
        int numberInput = userInput.nextInt();
        while (numberInput != 4) {
            if (numberInput == 1) {
                createAccount();
            } else if (numberInput == 2) {
                viewAccount();
            } else if(numberInput == 3){
                removeAccount();
            }
            System.out.println("Pick which feature you would like to use. 1. create account, 2. view account, " +
                    "3. delete account, 4. exit");
            numberInput = userInput.nextInt();
        }
    }
    private void createAccount() {
        System.out.println("Enter the type of account that you'd like to create. c for Checking, s for Saving, " +
                "or b for business");
        String charInput = userInput.next();
        if(charInput.equals("c")){
            createCheckingAccount();
        }else if(charInput.equals("s")){
            createSavingAccount();
        }else if(charInput.equals("b")){
            createBusinessAccount();
        }else{
            System.out.println();
        }
    }
    private void createCheckingAccount(){
        System.out.println("Enter the account number you wish to us: ");
        String newAccountNumber = userInput.next();
        System.out.println("Enter your name or company name: ");
        String newName = userInput.next();
        System.out.println("Enter your fees: ");
        double newFees = userInput.nextDouble();
        System.out.println("Enter a password: ");
        String newPassword = userInput.next();
        System.out.println("What is your account balance? ");
        double newBalance = userInput.nextDouble();
        CheckingAccount checkingAccount = new CheckingAccount(newAccountNumber,newFees, newName, newPassword, newBalance);
        this.accountsHashMap.put(newAccountNumber,checkingAccount);
    }
    private void createSavingAccount(){
        System.out.println("Enter the account number you wish to us: ");
        String newAccountNumber = userInput.next();
        System.out.println("Enter your name or company name: ");
        String newName = userInput.next();
        System.out.println("Enter your fees: ");
        double newFees = userInput.nextDouble();
        System.out.println("Enter your rate: ");
        double newRate = userInput.nextDouble();
        System.out.println("Enter a password: ");
        String newPassword = userInput.next();
        System.out.println("What is your account balance? ");
        double newBalance = userInput.nextDouble();
        SavingAccount savingAccount = new SavingAccount(newAccountNumber,newFees, newName, newPassword, newRate, newBalance);
        this.accountsHashMap.put(newAccountNumber,savingAccount);
    }
    private void createBusinessAccount(){
        System.out.println("Enter the account number you wish to us: ");
        String newAccountNumber = userInput.next();
        System.out.println("Enter your name or company name: ");
        String newName = userInput.next();
        System.out.println("Enter your fees: ");
        double newFees = userInput.nextDouble();
        System.out.println("Enter your tax ID: ");
        int newTaxId = userInput.nextInt();
        System.out.println("Enter a password: ");
        String newPassword = userInput.next();
        System.out.println("What is your account balance? ");
        double newBalance = userInput.nextDouble();
        BusinessAccount businessAccount = new BusinessAccount(newAccountNumber,newFees, newName, newPassword, newTaxId, newBalance);
        this.accountsHashMap.put(newAccountNumber,businessAccount);
    }
    private void viewAccount() {
        System.out.println("Please enter the account number: ");
        String accountNumber = userInput.next();
        if (accountsHashMap.containsKey(accountNumber)) {
            viewBankAccount(accountNumber);
        } else{
            invalidAccountNumber();
        }
    }
    private void viewBankAccount(String accountNumber) {
        BankAccount retrievedAccount = accountsHashMap.get(accountNumber);
        AccountTypeEnum accountTypeEnum = retrievedAccount.getAccountTypeEnum();
        if (accountTypeEnum == AccountTypeEnum.CHECKING_ACCOUNT) {
            viewCheckingAccount(retrievedAccount);
        } else if (accountTypeEnum == AccountTypeEnum.SAVING_ACCOUNT) {
            viewSavingAccount(retrievedAccount);
        } else if(accountTypeEnum == AccountTypeEnum.BUSINESS_ACCOUNT){
            viewBusinessAccount(retrievedAccount);
        }
    }
    private void viewCheckingAccount(BankAccount retrievedAccount) {
        CheckingAccount checkingAccount = (CheckingAccount) retrievedAccount;
        System.out.println(checkingAccount.toString());
        checkPassword(checkingAccount);
    }
    private void checkPassword(BankAccount retrievedAccount) {
        System.out.println("Enter your password: ");
        String newPassword = userInput.next();
        String Password = retrievedAccount.getPassword();
        if (newPassword.equals(Password)){
            System.out.println("Correct Password");
            System.out.println("Do you wish to add or take money out? 1. deposit, 2. withdraw");
            int numberInput = userInput.nextInt();
            if(numberInput == 1){
                depositMoney(retrievedAccount);
            } else {
                withdrawMoney(retrievedAccount);
            }
        }
        else{
            System.out.println("Incorrect Password, exiting account....");
            run();
        }
    }
    private void depositMoney(BankAccount retrievedAccount){
        System.out.println("Enter the amount you wish to deposit: ");
        double moneyAmount = userInput.nextDouble();
        retrievedAccount.setBalance(retrievedAccount.getBalance() + moneyAmount);
    }
    private void withdrawMoney(BankAccount retrievedAccount){
        System.out.println("Enter the amount you wish to withdraw: ");
        double moneyAmount = userInput.nextDouble();
        retrievedAccount.setBalance(retrievedAccount.getBalance() - moneyAmount);
    }
    private void viewSavingAccount(BankAccount retrievedAccount) {
        SavingAccount savingAccount = (SavingAccount) retrievedAccount;
        System.out.println(savingAccount.toString());
    }
    private void viewBusinessAccount(BankAccount retrievedAccount){
        BusinessAccount businessAccount = (BusinessAccount) retrievedAccount;
        System.out.println(businessAccount.toString());
    }
    private void removeAccount() {
        System.out.println("Please enter the account number of the account you wish to remove: ");
        String accountNumber = userInput.next();
        if (accountsHashMap.containsKey(accountNumber)) {
            accountsHashMap.remove(accountNumber);
        } else {
            invalidAccountNumber();
        }
    }
    private void invalidAccountNumber() {
        System.out.println("You've entered an invalid account number.");
        run();
    }
}