package BankOfKigali.Repayment;

import BankOfKigali.Loan.Loan;

import java.time.LocalDate;

public class Repayment {

    private String paymentId;
    private Loan loan;
    private double amountPaid;
    private LocalDate paymentDate;
    private double remainingBalance;

    // Constructors
    public Repayment() {}

    public Repayment(String paymentId, Loan loan, double amountPaid,
                     LocalDate paymentDate, double remainingBalance) {
        this.paymentId = paymentId;
        this.loan = loan;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
        this.remainingBalance = remainingBalance;
    }

    // Getters & Setters
    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

    public Loan getLoan() { return loan; }
    public void setLoan(Loan loan) { this.loan = loan; }

    public double getAmountPaid() { return amountPaid; }
    public void setAmountPaid(double amountPaid) { this.amountPaid = amountPaid; }

    public LocalDate getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDate paymentDate) { this.paymentDate = paymentDate; }

    public double getRemainingBalance() { return remainingBalance; }
    public void setRemainingBalance(double remainingBalance) { this.remainingBalance = remainingBalance; }

    // Update balance
    public void updateRemainingBalance(double payment) {
        this.remainingBalance -= payment;
    }

    // toString
    @Override
    public String toString() {
        return "Payment ID: " + paymentId +
                "\nAmount Paid: " + amountPaid +
                "\nDate: " + paymentDate +
                "\nRemaining Balance: " + remainingBalance;
    }
}
