import java.util.*;

public class Special_Prime_Finder {

    // Helper function to check if a number is prime
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Function to check if a number is a special prime
    public static boolean isSpecialPrime(int num) {
        String strNum = Integer.toString(num);
        // Check all prefixes of the number
        for (int i = 1; i <= strNum.length(); i++) {
            int prefix = Integer.parseInt(strNum.substring(0, i));
            if (!isPrime(prefix)) return false;  // If any prefix is not prime, return false
        }
        return true;
    }

    // Function to find the largest special prime less than the given number
    public static int findLargestSpecialPrime(int limit) {
        for (int i = limit - 1; i >= 2; i--) {
            if (isPrime(i) && isSpecialPrime(i)) {
                return i;  // Return the first special prime found
            }
        }
        return -1;  // Return -1 if no special prime is found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        int result = findLargestSpecialPrime(input);
        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("No special prime found.");
        }

        sc.close();
    }
}
