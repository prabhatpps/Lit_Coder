import java.util.Scanner;

public class Desire_Construction {

    // Function to calculate the factorial of a number
    public static long factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    // Function to calculate binomial coefficient C(n, k)
    public static long binomialCoefficient(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    // Function to find the number of ways to distribute floors
    public static String calculateWays(int plots, int floors) {
        // Check for invalid input
        if (floors < plots) {
            return "Invalid Input";
        }

        // Calculate remaining floors after assigning 1 floor to each plot
        int remainingFloors = floors - plots;

        // Calculate the number of ways using the binomial coefficient formula
        long ways = binomialCoefficient(remainingFloors + plots - 1, plots - 1);
        return String.valueOf(ways);
    }

    // Main function to take input and output the result
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the number of plots
        int plots = scanner.nextInt();

        // Taking input for the number of floors
        int floors = scanner.nextInt();

        // Validate and calculate the result
        String result = calculateWays(plots, floors);
        System.out.println(result);

        scanner.close();
    }
}
