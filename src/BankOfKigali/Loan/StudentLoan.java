package BankOfKigali.Loan;

public class StudentLoan extends LoanManager {

    private String universityName;

    public StudentLoan(String loanId, double loanAmount, double interestRate,
                       int durationMonths, String loanStatus,
                       String officerName, String branchLocation,
                       String universityName) {

        super(loanId, "Student Loan", loanAmount, interestRate,
                durationMonths, loanStatus, officerName, branchLocation);
        this.universityName = universityName;
    }

    @Override
    public boolean checkEligibility(double income) {
        return true; // flexible for students
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * 0.05;
    }

    @Override
    public void approveLoan() {
        setLoanStatus("Approved - Student Support");
    }

    @Override
    public String toString() {
        return super.toString() + "\nUniversity: " + universityName;
    }
}
