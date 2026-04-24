package BankOfKigali.Loan;

public class AgriculturalLoan extends LoanManager {

    private double farmSize;

    public AgriculturalLoan(String loanId, double loanAmount, double interestRate,
                            int durationMonths, String loanStatus,
                            String officerName, String branchLocation,
                            double farmSize) {

        super(loanId, "Agricultural Loan", loanAmount, interestRate,
                durationMonths, loanStatus, officerName, branchLocation);
        this.farmSize = farmSize;
    }

    @Override
    public boolean checkEligibility(double income) {
        return farmSize >= 2; // hectares
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * 0.06;
    }

    @Override
    public String generateLoanReport() {
        return "Agricultural Loan for farm size: " + farmSize + " hectares\n" + super.toString();
    }

    @Override
    public String toString() {
        return super.toString() + "\nFarm Size: " + farmSize + " hectares";
    }
}
