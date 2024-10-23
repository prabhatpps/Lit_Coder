import java.util.Scanner;

public class Pin_Generator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input array
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");

        // Result to store the generated PIN
        StringBuilder pin = new StringBuilder();

        // Process each number in the input
        for (String num : numbers) {
            int cumulativeSum = getCumulativeSum(num);

            // Check if the cumulative sum is odd or even
            if (cumulativeSum % 2 == 1) {
                // Odd: Convert to respective lowercase letter
                char letter = (char) ('a' + (cumulativeSum - 1)); // 1 -> 'a', 3 -> 'c', etc.
                pin.append(letter);
            } else {
                // Even: Append the number as it is
                pin.append(cumulativeSum);
            }
        }

        // Output the generated PIN
        System.out.println(pin.toString());
        scanner.close();
    }

    // Function to get the cumulative sum of digits until a single digit is obtained
    private static int getCumulativeSum(String num) {
        int sum = 0;

        // Get sum of digits
        for (char digit : num.toCharArray()) {
            sum += digit - '0'; // Convert char to its numeric value
        }

        // Reduce to a single digit if necessary
        while (sum >= 10) {
            int tempSum = 0;
            while (sum > 0) {
                tempSum += sum % 10;
                sum /= 10;
            }
            sum = tempSum;
        }

        return sum;
    }
}
