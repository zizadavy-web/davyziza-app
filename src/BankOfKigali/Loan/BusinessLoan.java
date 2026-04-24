package BankOfKigali.Loan;

public class BusinessLoan extends LoanManager {

    private String businessType;

    public BusinessLoan(String loanId, double loanAmount, double interestRate,
                        int durationMonths, String loanStatus,
                        String officerName, String branchLocation,
                        String businessType) {

        super(loanId, "Business Loan", loanAmount, interestRate,
                durationMonths, loanStatus, officerName, branchLocation);
        this.businessType = businessType;
    }

    @Override
    public boolean checkEligibility(double income) {
        return income >= (getLoanAmount() / 2);
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * 0.15;
    }

    @Override
    public void approveLoan() {
        setLoanStatus("Approved - Business");
    }

    @Override
    public String toString() {
        return super.toString() + "\nBusiness Type: " + businessType;
    }
}
