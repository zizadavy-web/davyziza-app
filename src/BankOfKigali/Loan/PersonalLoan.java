package BankOfKigali.Loan;

public class PersonalLoan extends LoanManager {

    private String employmentStatus;

    public PersonalLoan(String loanId, double loanAmount, double interestRate,
                        int durationMonths, String loanStatus,
                        String officerName, String branchLocation,
                        String employmentStatus) {

        super(loanId, "Personal Loan", loanAmount, interestRate,
                durationMonths, loanStatus, officerName, branchLocation);
        this.employmentStatus = employmentStatus;
    }

    @Override
    public boolean checkEligibility(double income) {
        return income >= (getLoanAmount() / 3) && employmentStatus.equalsIgnoreCase("Employed");
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * 0.12; // fixed 12%
    }

    @Override
    public String generateLoanReport() {
        return "Personal Loan Report\n" + super.toString();
    }

    @Override
    public String toString() {
        return super.toString() + "\nEmployment Status: " + employmentStatus;
    }
}
