package com.bankapplication.controller;

import java.util.Scanner;

import com.bankapplication.service.RBI;
import com.bankapplication.serviceimplemnent.SBI;

public class ALL {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		boolean flag = true;

		RBI rbi = new SBI();

		while (flag) {
            Scanner sc1 = new Scanner(System.in);
			System.out.println("1: CREAT ACCOUNT");
			System.out.println("2: SHOW ACCOUNT DETAILS");
			System.out.println("3: SHOW ACCOUNT BALANCE");
			System.out.println("4:DEPOSITE MONEY");
			System.out.println("5: WITHDRAW MONEY");
			System.out.println("6:UPDATE ACCOUNT DETAILS");
			System.out.println("7:EXIT");
			int ch = 0;
			System.out.println("enter a number");
			try {

				ch = sc1.nextInt();
			} catch (Exception e) {

				System.out.println("enter integer value");
				System.out.println(e);
			}

			switch (ch) {

			case 1:
				rbi.registerAccount();
				break;
			case 2:
				rbi.showAccountDetails();
				break;
			case 3:
				System.out.println("enter acc no");
				rbi.showAccountBalance();
				break;
			case 4:
				rbi.depositeMoney();
				break;
			case 5:
				rbi.withdrawMoney();
				break;
			case 6:
				rbi.updateAccountDetails();
				break;
			case 7:
				flag = false;
				break;
			default:
				System.out.println("wrong choice");
				break;

			}
		}

	}

}
