package BankOfKigali.Loan;

public class LoanManager extends Loan implements PayableInt {

    private String officerName;
    private String branchLocation;
    private double remainingBalance;

    // Default constructor
    public LoanManager() {
    }

    // Parameterized constructor
    public LoanManager(String loanId, String loanType, double loanAmount,
                       double interestRate, int durationMonths, String loanStatus,
                       String officerName, String branchLocation) {

        super(loanId, loanType, loanAmount, interestRate, durationMonths, loanStatus);
        this.officerName = officerName;
        this.branchLocation = branchLocation;
        this.remainingBalance = loanAmount;
    }

    // Getters and Setters
    public String getOfficerName() { return officerName; }
    public void setOfficerName(String officerName) { this.officerName = officerName; }

    public String getBranchLocation() { return branchLocation; }
    public void setBranchLocation(String branchLocation) { this.branchLocation = branchLocation; }

    // -----------------------------
    // Implement Abstract Methods
    // -----------------------------

    @Override
    public double calculateInterest() {
        return getLoanAmount() * getInterestRate() / 100;
    }

    @Override
    public double calculateMonthlyInstallment() {
        return calculateTotalRepayment() / getDurationMonths();
    }

    @Override
    public boolean checkEligibility(double income) {
        return income >= (getLoanAmount() / 2);
    }

    @Override
    public void approveLoan() {
        setLoanStatus("Approved");
    }

    @Override
    public void rejectLoan() {
        setLoanStatus("Rejected");
    }

    @Override
    public double calculateTotalRepayment() {
        return getLoanAmount() + calculateInterest();
    }

    @Override
    public String generateLoanReport() {
        return "Loan Report:\n" + toString() +
                "\nTotal Repayment: " + calculateTotalRepayment();
    }

    @Override
    public boolean validateLoanDetails() {
        return getLoanAmount() > 0 && getInterestRate() > 0 && getDurationMonths() > 0;
    }

    // -----------------------------
    // Implement Interface Methods
    // -----------------------------

    @Override
    public void processPayment(double amount) {
        remainingBalance -= amount;
    }

    @Override
    public double calculateRemainingBalance() {
        return remainingBalance;
    }

    @Override
    public String generatePaymentReceipt(double amount) {
        return "Payment of " + amount + " processed. Remaining Balance: " + remainingBalance;
    }

    // toString()
    @Override
    public String toString() {
        return super.toString() +
                "\nOfficer: " + officerName +
                "\nBranch: " + branchLocation +
                "\nRemaining Balance: " + remainingBalance;
    }
}
