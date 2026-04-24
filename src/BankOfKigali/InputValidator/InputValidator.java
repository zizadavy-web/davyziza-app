package BankOfKigali.InputValidator;

public class InputValidator {

    public static boolean isEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Error: Input cannot be empty.");
            return true;
        }
        return false;
    }

    public static boolean isNegative(double value) {
        if (value <= 0) {
            System.out.println("Error: Value must be greater than zero.");
            return true;
        }
        return false;
    }

    public static boolean isValidInterest(double rate) {
        if (rate <= 0 || rate > 100) {
            System.out.println("Error: Interest rate must be between 1 and 100.");
            return false;
        }
        return true;
    }

    public static boolean isValidPhone(String phone) {
        if (!phone.matches("\\d{10,13}")) {
            System.out.println("Error: Invalid phone number format.");
            return false;
        }
        return true;
    }

    public static boolean isValidNationalId(String id) {
        if (!id.matches("\\d{16}")) {
            System.out.println("Error: National ID must be 16 digits.");
            return false;
        }
        return true;
    }

    public static boolean isValidLoanType(String type) {
        String[] valid = {"personal", "home", "car", "business", "student", "agricultural"};
        for (String v : valid) {
            if (v.equalsIgnoreCase(type)) return true;
        }
        System.out.println("Error: Invalid loan type.");
        return false;
    }
}
