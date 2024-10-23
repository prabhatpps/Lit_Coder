import java.util.Scanner;

public class Divisible_sum_pairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read divisor
        int k = scanner.nextInt();

        // Read array elements
        scanner.nextLine(); // Move to the next line
        String[] inputArray = scanner.nextLine().split(" ");

        int[] ar = new int[inputArray.length];

        // Parse array of integers
        for (int i = 0; i < inputArray.length; i++) {
            ar[i] = Integer.parseInt(inputArray[i]);
        }

        int count = 0; // To count the valid pairs

        // Iterate over the array to find all pairs
        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                // Check if the sum of ar[i] and ar[j] is divisible by k
                if ((ar[i] + ar[j]) % k == 0) {
                    count++;
                }
            }
        }

        // Output the count of valid pairs
        System.out.println(count);

        scanner.close();
    }
}
