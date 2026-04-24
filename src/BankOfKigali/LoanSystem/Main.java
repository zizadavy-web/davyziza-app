package BankOfKigali.LoanSystem;

import BankOfKigali.Customer.Customer;
import BankOfKigali.InputValidator.InputValidator;
import BankOfKigali.Loan.Loan;
import BankOfKigali.Loan.LoanManager;
import BankOfKigali.LoanFactory.LoanFactory;
import BankOfKigali.Repayment.Repayment;

import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // -----------------------------
        // CUSTOMER INPUT
        // -----------------------------
        System.out.print("Enter Customer ID: ");
        String custId = sc.nextLine();

        while (InputValidator.isEmpty(custId)) {
            custId = sc.nextLine();
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter National ID: ");
        String nid = sc.nextLine();
        while (!InputValidator.isValidNationalId(nid)) {
            nid = sc.nextLine();
        }

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        while (!InputValidator.isValidPhone(phone)) {
            phone = sc.nextLine();
        }

        Customer customer = new Customer(custId, name, nid, phone);

        // -----------------------------
        // LOAN INPUT
        // -----------------------------
        System.out.print("Enter Loan Type: ");
        String type = sc.nextLine();
        while (!InputValidator.isValidLoanType(type)) {
            type = sc.nextLine();
        }

        System.out.print("Enter Loan Amount: ");
        double amount = sc.nextDouble();
        while (InputValidator.isNegative(amount)) {
            amount = sc.nextDouble();
        }

        System.out.print("Enter Interest Rate: ");
        double rate = sc.nextDouble();
        while (!InputValidator.isValidInterest(rate)) {
            rate = sc.nextDouble();
        }

        System.out.print("Enter Duration (months): ");
        int duration = sc.nextInt();

        sc.nextLine(); // clear buffer

        Loan loan = LoanFactory.createLoan(
                type, "L001", amount, rate, duration,
                "Officer A", "Kigali"
        );

        // -----------------------------
        // PAYMENT
        // -----------------------------
        System.out.print("Enter Payment Amount: ");
        double payment = sc.nextDouble();

        ((LoanManager) loan).processPayment(payment);

        Repayment repayment = new Repayment(
                "P001", loan, payment,
                LocalDate.now(),
                ((LoanManager) loan).calculateRemainingBalance()
        );

        // -----------------------------
        // OUTPUT
        // -----------------------------
        System.out.println("\n===== CUSTOMER =====");
        System.out.println(customer);

        System.out.println("\n===== LOAN =====");
        System.out.println(loan);

        System.out.println("\n===== REPAYMENT =====");
        System.out.println(repayment);
    }
}
