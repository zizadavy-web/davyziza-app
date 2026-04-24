package BankOfKigali.Loan;

public abstract class Loan {
    // Private attributes
    private String loanId;
    private String loanType;
    private double loanAmount;
    private double interestRate;
    private int durationMonths;
    private String loanStatus;

    // Default constructor
    public Loan() {
    }

    // Parameterized constructor
    public Loan(String loanId, String loanType, double loanAmount,
                double interestRate, int durationMonths, String loanStatus) {
        this.loanId = loanId;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.durationMonths = durationMonths;
        this.loanStatus = loanStatus;
    }

    // Getters and Setters
    public String getLoanId() { return loanId; }
    public void setLoanId(String loanId) { this.loanId = loanId; }

    public String getLoanType() { return loanType; }
    public void setLoanType(String loanType) { this.loanType = loanType; }

    public double getLoanAmount() { return loanAmount; }
    public void setLoanAmount(double loanAmount) { this.loanAmount = loanAmount; }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    public int getDurationMonths() { return durationMonths; }
    public void setDurationMonths(int durationMonths) { this.durationMonths = durationMonths; }

    public String getLoanStatus() { return loanStatus; }
    public void setLoanStatus(String loanStatus) { this.loanStatus = loanStatus; }

    // toString()
    @Override
    public String toString() {
        return "Loan ID: " + loanId +
                "\nType: " + loanType +
                "\nAmount: " + loanAmount +
                "\nInterest Rate: " + interestRate +
                "\nDuration: " + durationMonths +
                "\nStatus: " + loanStatus;
    }

    // Abstract Methods
    public abstract double calculateInterest();
    public abstract double calculateMonthlyInstallment();
    public abstract boolean checkEligibility(double income);
    public abstract void approveLoan();
    public abstract void rejectLoan();
    public abstract double calculateTotalRepayment();
    public abstract String generateLoanReport();
    public abstract boolean validateLoanDetails();
}
