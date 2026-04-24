package BankOfKigali.LoanFactory;

import BankOfKigali.Loan.*;

public class LoanFactory {

    public static Loan createLoan(String type, String loanId, double amount,
                                  double rate, int duration,
                                  String officer, String branch) {

        switch (type.toLowerCase()) {

            case "personal":
                return new PersonalLoan(loanId, amount, rate, duration,
                        "Pending", officer, branch, "Employed");

            case "home":
                return new HomeLoan(loanId, amount, rate, duration,
                        "Pending", officer, branch, 200000);

            case "car":
                return new CarLoan(loanId, amount, rate, duration,
                        "Pending", officer, branch, "Toyota");

            case "business":
                return new BusinessLoan(loanId, amount, rate, duration,
                        "Pending", officer, branch, "Retail");

            case "student":
                return new StudentLoan(loanId, amount, rate, duration,
                        "Pending", officer, branch, "UR");

            case "agricultural":
                return new AgriculturalLoan(loanId, amount, rate, duration,
                        "Pending", officer, branch, 3);

            default:
                return null;
        }
    }
}
