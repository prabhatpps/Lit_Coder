import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PYTHAGOREAN_TRIPLETS {

    // Function to find Pythagorean triplets in the given array
    public static String findPythagoreanTriplets(int[] arr) {
        // Input validation
        if (arr.length < 3 || arr.length > 15) {
            return "Invalid Input";
        }

        for (int i : arr) {
            if (!(i > 0)) {
                return "Invalid Input";
            }
        }

        // Sort the array
        Arrays.sort(arr);

        int tripletCount = 0;
        int n = arr.length;

        // Convert elements to their squares for easier comparison
        int[] squares = new int[n];
        for (int i = 0; i < n; i++) {
            squares[i] = arr[i] * arr[i];
        }

        // Check for Pythagorean triplets using two-pointer technique
        for (int c = n - 1; c >= 2; c--) {
            int a = 0;
            int b = c - 1;

            while (a < b) {
                // Check for the Pythagorean condition
                if (squares[a] + squares[b] == squares[c]) {
                    tripletCount++;
                    a++;
                    b--;
                } else if (squares[a] + squares[b] < squares[c]) {
                    a++;
                } else {
                    b--;
                }
            }
        }

        // Return result based on whether triplets were found
        if (tripletCount > 0) {
            return "True\n" + tripletCount;
        } else {
            return "False\n" + arr.length;
        }
    }

    // Main method to take dynamic input and test the function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        // Taking dynamic array input from the user
        System.out.println("Enter the elements of the array (input a non-integer to stop):");

        // Loop to take input until a non-integer is entered
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            list.add(num);
        }

        // Convert ArrayList to int array
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        // Check if input size is valid
        if (arr.length < 3 || arr.length > 15) {
            System.out.println("Invalid Input");
        } else {
            // Call the function to find Pythagorean triplets
            String result = findPythagoreanTriplets(arr);
            System.out.println(result);
        }

        scanner.close();
    }
}
