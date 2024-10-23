import java.util.Scanner;

public class ArrayManipulation {

    public static long arrayManipulation(int n, int[][] queries) {
        // Create a difference array initialized to 0
        long[] arr = new long[n + 1];  // Using n + 1 for easier index handling

        // Apply each operation to the difference array
        for (int[] query : queries) {
            int a = query[0];
            int b = query[1];
            long k = query[2];
            arr[a] += k;  // Add k to the start index
            if (b + 1 <= n) {
                arr[b + 1] -= k;  // Subtract k from the element right after the end index
            }
        }

        // Calculate the maximum value using prefix sums
        long maxValue = 0;
        long currentValue = 0;

        for (int i = 1; i <= n; i++) {
            currentValue += arr[i];  // Build the prefix sum
            if (currentValue > maxValue) {
                maxValue = currentValue;  // Track the maximum value
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Input for the number of queries
        System.out.print("Enter the number of queries: ");
        int q = scanner.nextInt();

        // Initializing the queries array
        int[][] queries = new int[q][3];

        // Input for each query
        System.out.println("Enter the queries (format: start end value):");
        for (int i = 0; i < q; i++) {
            System.out.print("Query " + (i + 1) + ": ");
            queries[i][0] = scanner.nextInt(); // start index
            queries[i][1] = scanner.nextInt(); // end index
            queries[i][2] = scanner.nextInt(); // value to add
        }

        // Calling the array manipulation function and displaying the result
        long result = arrayManipulation(n, queries);
        System.out.println("The maximum value in the array after all operations is: " + result);

        scanner.close();
    }
}
