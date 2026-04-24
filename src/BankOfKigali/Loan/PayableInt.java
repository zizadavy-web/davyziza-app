package BankOfKigali.Loan;

interface PayableInt {
    void processPayment(double amount);
    double calculateRemainingBalance();
    String generatePaymentReceipt(double amount);
}
