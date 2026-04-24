package BankOfKigali.Loan;

public class HomeLoan extends LoanManager {

    private double propertyValue;

    public HomeLoan(String loanId, double loanAmount, double interestRate,
                    int durationMonths, String loanStatus,
                    String officerName, String branchLocation,
                    double propertyValue) {

        super(loanId, "Home Loan", loanAmount, interestRate,
                durationMonths, loanStatus, officerName, branchLocation);
        this.propertyValue = propertyValue;
    }

    @Override
    public boolean checkEligibility(double income) {
        return income >= (getLoanAmount() / 2) && propertyValue > getLoanAmount();
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * 0.08;
    }

    @Override
    public double calculateMonthlyInstallment() {
        return calculateTotalRepayment() / getDurationMonths();
    }

    @Override
    public String toString() {
        return super.toString() + "\nProperty Value: " + propertyValue;
    }
}
