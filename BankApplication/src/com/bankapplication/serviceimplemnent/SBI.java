package com.bankapplication.serviceimplemnent;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.bankapplication.model.*;
import com.bankapplication.service.*;

public class SBI implements RBI {

	Scanner sc = new Scanner(System.in);
	MODEL model = new MODEL();

	@Override
	public void registerAccount() {
		// System.out.println("enter account number");
		model.setAcountNo(AccountNo());
		// System.out.println("enter account name");
		model.setAccountName(AccountName());
		// System.out.println("enter your adhar number");
		model.setAdharcard(AdharNumber());
		// System.out.println("enter your pan number");
		model.setPancard(Pancard());
		System.out.println("enter mobile no");
		model.setMonileNo(sc.nextLong());
		System.out.println("enter account balance");
		model.setAccountbalance(sc.nextDouble());
		System.out.println("account registraction sucessfully");

	}

	public int AccountNo() {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter account number");
		int ch = 0;
		try {

			ch = sc.nextInt();

		} catch (InputMismatchException e) {

			System.out.println("enter valid number");
			return AccountNo();
		}

		String accnum = String.valueOf(ch);
		if (ch <= 0 || accnum.length() != 5) {
			return AccountNo();
		}
		return ch;
	}

	public String AccountName() {

		Scanner sc = new Scanner(System.in);
		// System.out.println("type here account name");
		String s;
		try {
			System.out.println("type here account name");
			s = sc.next();
			if (s.length() != 10 || s.toUpperCase() != s) {

				return AccountName();
			}

		} catch (Exception e) {

			System.out.println("please enter capital letter");
			System.out.println(e);

			return AccountName();
		}

//		if (s.length() != 10 || s.toUpperCase() != s) {
//
//			return AccountName();
//		}

		return s;

	}

	public long AdharNumber() {

		Scanner sc = new Scanner(System.in);
		long adnum;
		try {
			System.out.println("enter here your 12 digit adhar number");

			adnum = sc.nextLong();

		} catch (Exception e) {
			System.out.println("you enter wrong number try again");
			System.out.println(e);
			return AdharNumber();
		}

		String s = String.valueOf(adnum);
		if (s.toUpperCase() != s || s.length() != 12) {

			return AdharNumber();
		}

		return adnum;
	}

	public String Pancard() {

		Scanner sc = new Scanner(System.in);
		// String s = null;
		System.out.println("enter your pancard number");
		String s = sc.next();
		try {
			// System.out.println("enter your pancard number");
			// s = sc.next();

		} catch (Exception e) {
			System.out.println(e);
		}

		if (s.length() != 10) {

			return Pancard();
		}

		return s;

	}

	@Override
	public void showAccountDetails() {

		System.out.println("enter your account number");

		int accNO = sc.nextInt();

		if (accNO == model.getAcountNo()) {

			System.out.println("account name is:" + model.getAccountName());
			System.out.println("adhar number is:" + model.getAdharcard());
			System.out.println("pan number is:" + model.getPancard());
			System.out.println("mobile no is:" + model.getMonileNo());
			System.out.println("account balance is:" + model.getAccountbalance());

		}

		else {

			System.out.println("wrong account number please enter again");
			showAccountDetails();

		}

	}

	@Override

	public void showAccountBalance() {
		System.out.println("Enter account Num ");
		int accNO = sc.nextInt();

		if (accNO == model.getAcountNo()) {

			System.out.println("account balance is:" + model.getAccountbalance());

		}

		else {

			System.out.println("you enter wrong number please enter again");
			showAccountBalance();

		}

	}

	@Override
	public void withdrawMoney() {

		System.out.println("Enter Account Num");
		int accNo = sc.nextInt();

		if (accNo == model.getAcountNo()) {
			System.out.println("Enter money withdraw");
			double withdrawMoney = model.getAccountbalance() - sc.nextDouble();
			model.setAccountbalance(withdrawMoney);
			System.out.println("withdraw money is:" + model.getAccountbalance());
		}

		else {

			System.out.println("you enter wrong account num .enter again");
			withdrawMoney();

		}
	}

	@Override
	public void depositeMoney() {
		System.out.println("Enter Account Num is");

		int accNo = sc.nextInt();

		if (accNo == model.getAcountNo()) {
			System.out.println("Enter amount deposite");
			double addMoney = model.getAccountbalance() + sc.nextDouble();
			model.setAccountbalance(addMoney);
			System.out.println("the deposite money is :" + model.getAccountbalance());
		} else {

			System.out.println("you enter wrong accNo .please enter again");
			depositeMoney();
		}

	}

	@Override
	public void updateAccountDetails() {
		System.out.println("1: for update account name");
		System.out.println("2:enter adhar num for update");
		System.out.println("3:enter mobile num for update");
		System.out.println("4:enter pancard num for update");
		System.out.println("select the number");
		int ch = sc.nextInt();
		System.out.println("Enter the account number");
		int accNo = sc.nextInt();

		if (accNo == model.getAcountNo()) {
			switch (ch) {

			case 1:
				System.out.println("update account name");
				model.setAccountName(sc.next());
				break;
			case 2:
				System.out.println("Enter adhar num for update");
				model.setAdharcard(sc.nextLong());
				break;
			case 3:
				System.out.println("Enter mobile num is for update");
				model.setMonileNo(sc.nextLong());
				break;
			case 4:
				System.out.println("enter pancard num for update");
				model.setPancard(sc.next());
				break;

			case 5:
				boolean flag = false;
				break;

			default:
				System.out.println("do not update");
				break;

			}
		} else {

			System.out.println("you enter wrong accNO.please enter again");
			updateAccountDetails();

		}

//		System.out.println("Enter Account Num is :");
//		int accNo = sc.nextInt();
//
//		if (accNo == model.getAcountNo()) {
//			
//			System.out.println("enter account num for update");
//			model.setAcountNo(sc.nextInt());
//			
//			System.out.println("Enter account name for update");
//			model.setAccountName(sc.next());
//			//System.out.println(" update account name is:" + model.getAccountName());
//            
//			System.out.println("Enter adhar num for update");
//			model.setAdharcard(sc.next());
//		//	System.out.println("update adhar Num is:" + model.getAdharcard());
//             
//			System.out.println("Enter mobile num is for update");
//			model.setMonileNo(sc.nextLong());
//   			//System.out.println("update mobile Num is : " + model.getMonileNo());
//
//			System.out.println("enter pancard num for update");
//			model.setPancard(sc.next());
//			//System.out.println("update pancard Num is :" + model.getPancard());
//		}
		// sc.close();
		// System.out.println("thank you");
	}

}
