package BankOfKigali.Loan;

public class CarLoan extends LoanManager {

    private String carModel;

    public CarLoan(String loanId, double loanAmount, double interestRate,
                   int durationMonths, String loanStatus,
                   String officerName, String branchLocation,
                   String carModel) {

        super(loanId, "Car Loan", loanAmount, interestRate,
                durationMonths, loanStatus, officerName, branchLocation);
        this.carModel = carModel;
    }

    @Override
    public boolean checkEligibility(double income) {
        return income >= (getLoanAmount() / 4);
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * 0.10;
    }

    @Override
    public String generateLoanReport() {
        return "Car Loan for model: " + carModel + "\n" + super.toString();
    }

    @Override
    public String toString() {
        return super.toString() + "\nCar Model: " + carModel;
    }
}
