import java.util.*;

public class Zero_Sum_Subarray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input array as a string
        String input = scanner.nextLine();

        // Split the input by spaces to get array elements
        String[] inputElements = input.split(" ");

        // Check if array size is within limits
        int n = inputElements.length;
        if (n < 1 || n > 10) {
            System.out.println("Array size must be between 1 and 10");
            return;
        }

        // Convert string elements to integer array and check constraints
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            try {
                arr[i] = Integer.parseInt(inputElements[i]);
                if (arr[i] < -10 || arr[i] > 10) {
                    System.out.println("Array elements must be from -10 to 10");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Array elements must be integers");
                return;
            }
        }

        // Check if a subarray with zero sum exists
        boolean foundZeroSumSubarray = checkZeroSumSubarray(arr);

        // Output the result
        if (foundZeroSumSubarray) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        // Output the length of the array
        System.out.println(n);

        scanner.close();
    }

    // Function to check if there exists a subarray with sum = 0
    private static boolean checkZeroSumSubarray(int[] arr) {
        Set<Integer> cumulativeSumSet = new HashSet<>();
        int cumulativeSum = 0;

        for (int value : arr) {
            cumulativeSum += value;

            // If cumulative sum is 0 or it's already seen, we found a subarray
            if (cumulativeSum == 0 || cumulativeSumSet.contains(cumulativeSum)) {
                return true;
            }

            // Add cumulative sum to the set
            cumulativeSumSet.add(cumulativeSum);
        }

        return false; // No zero sum subarray found
    }
}
