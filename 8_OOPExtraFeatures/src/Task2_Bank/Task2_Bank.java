package Task2_Bank;

import Task2_Bank.accounts.Accounts;
import Task2_Bank.accounts.DepositAccount;
import Task2_Bank.accounts.LoanAccount;
import Task2_Bank.accounts.MortgageAccount;
import Task2_Bank.owners.CompanyCustomer;
import Task2_Bank.owners.IndividualCustomer;
import Task2_Bank.owners.Owners;

import java.util.Scanner;

public class Task2_Bank {
    public static void main(String[] args) {
        Accounts dep = null;
        Owners customer;
        Scanner sc = new Scanner(System.in);
        String input = "";
        int IBAN = 1;
        String formatted;
        do{
            input = sc.nextLine();
            if(input.equals("END")) break;
            String[] split = input.split(" ");
            //OPEN peter 1 1 1982 0.88
            // OPEN PgbLtd. 2 2 220000 0.45
            // OPEN Svoge 2 3 1000000 0.22
            // PUT peter 1000
            if (split[0].equalsIgnoreCase("OPEN")){
                if (split[2].equalsIgnoreCase("1") && split[3].equalsIgnoreCase("1")) {
                    customer = new IndividualCustomer(split[1], 1);
                    dep = new DepositAccount(formatted = String.format("%08d", IBAN), customer, Float.parseFloat(split[4]), Float.parseFloat(split[5]));
                }
                if (split[2].equalsIgnoreCase("2") && split[3].equalsIgnoreCase("1")) {
                    customer = new CompanyCustomer(split[1], 2);
                    dep = new DepositAccount(formatted = String.format("%08d", IBAN), customer, Float.parseFloat(split[4]), Float.parseFloat(split[5]));
                }
                if (split[2].equalsIgnoreCase("1") && split[3].equalsIgnoreCase("2")) {
                    customer = new IndividualCustomer(split[1], 1);
                    dep = new LoanAccount(formatted = String.format("%08d", IBAN), customer, Float.parseFloat(split[4]), Float.parseFloat(split[5]));
                }
                if (split[2].equalsIgnoreCase("2") && split[3].equalsIgnoreCase("2")) {
                    customer = new CompanyCustomer(split[1], 2);
                    dep = new DepositAccount(formatted = String.format("%08d", IBAN), customer, Float.parseFloat(split[4]), Float.parseFloat(split[5]));
                }
                if (split[2].equalsIgnoreCase("1") && split[3].equalsIgnoreCase("3")) {
                    customer = new IndividualCustomer(split[1], 1);
                    dep = new DepositAccount(formatted = String.format("%08d", IBAN), customer, Float.parseFloat(split[4]), Float.parseFloat(split[5]));
                }
                if (split[2].equalsIgnoreCase("2") && split[3].equalsIgnoreCase("3")) {
                    customer = new CompanyCustomer(split[1], 2);
                    dep = new MortgageAccount(formatted = String.format("%08d", IBAN), customer, Float.parseFloat(split[4]), Float.parseFloat(split[5]));
                }
                System.out.println(dep.getIBAN());
                IBAN++;
            }
            //PUT peter 1000
            if (split[0].equalsIgnoreCase("PUT")){
                if (split[1].equals(dep.getOwnername()) || split[1].equals(dep.getIBAN())){
                    dep.balance = dep.balance + Float.parseFloat(split[2]);
                }

            }
            if (split[0].equalsIgnoreCase("GET")){
                if (split[1].equals(dep.getOwnername()) || split[1].equals(dep.getIBAN())){
                    dep.balance = dep.balance - Float.parseFloat(split[2]);
                }
            }
            if (split[0].equalsIgnoreCase("INFO")) {
                if (split[1].equals(dep.getOwnername()) || split[1].equals(dep.getIBAN())){
                    System.out.println(dep.countRate(Integer.parseInt(split[2])));
                }
            }

        }while(!input.equals("END"));

    }

}
