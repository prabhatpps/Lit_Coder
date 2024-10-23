import java.util.*;

public class Find_Missing_Digit {

    // Function to convert a string number from a given base to decimal
    public static int convertToDecimal(String num, int base) {
        try {
            return Integer.parseInt(num, base);
        } catch (NumberFormatException e) {
            return -1; // Indicate invalid input
        }
    }

    // Function to validate the input number for a given base
    public static boolean isValidNumber(String num, int base) {
        String allowedChars = "0123456789ABCDEF";
        for (char c : num.toUpperCase().toCharArray()) {
            if (c == 'x' || c == 'X') {
                continue;
            }
            if (allowedChars.indexOf(c) >= base || allowedChars.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input: original number and base
        String[] input1 = scanner.nextLine().split(" ");
        String originalNumber = input1[0];
        int originalBase = Integer.parseInt(input1[1]);

        // Read input: converted number with 'x' and base
        String[] input2 = scanner.nextLine().split(" ");
        String convertedNumber = input2[0];
        int convertedBase = Integer.parseInt(input2[1]);

        // Validate original number for its base
        if (!isValidNumber(originalNumber, originalBase)) {
            System.out.println("Wrong Input");
            return;
        }

        // Validate converted number for its base
        if (!isValidNumber(convertedNumber.replace("x", "0"), convertedBase)) {
            System.out.println("Wrong Input");
            return;
        }

        // Convert original number to decimal
        int decimalOriginal = convertToDecimal(originalNumber, originalBase);
        if (decimalOriginal == -1) {
            System.out.println("Wrong Input");
            return;
        }

        // Try replacing 'x' with each possible digit in the converted number's base
        for (int i = 0; i < convertedBase; i++) {
            // Replace 'x' with the current digit
            String testNumber = convertedNumber.replace("x", Integer.toString(i, convertedBase).toUpperCase());

            // Convert the test number to decimal
            int testDecimal = convertToDecimal(testNumber, convertedBase);

            // If the test number matches the original decimal number, we found the correct digit
            if (testDecimal == decimalOriginal) {
                System.out.println(i);
                return;
            }
        }

        // If no valid digit found, something went wrong
        System.out.println("Wrong Input");
    }
}
