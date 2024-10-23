import java.util.*;

public class Adding_Two_Negabinary_Numbers {

    // Function to add two negabinary numbers
    public static List<Integer> addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        int i = arr1.length - 1, j = arr2.length - 1;

        // Process each bit from right to left (least significant to most significant)
        while (i >= 0 || j >= 0 || carry != 0) {
            int bit1 = (i >= 0) ? arr1[i] : 0;
            int bit2 = (j >= 0) ? arr2[j] : 0;

            // Add current bits and carry
            int sum = bit1 + bit2 + carry;

            // Handle the sum based on base -2
            if (sum >= 2) {
                result.add(sum - 2);
                carry = -1;
            } else if (sum == -1) {
                result.add(1);
                carry = 1;
            } else {
                result.add(sum);
                carry = 0;
            }

            // Move to the next bits
            i--;
            j--;
        }

        // Remove leading zeros
        while (result.size() > 1 && result.get(result.size() - 1) == 0) {
            result.remove(result.size() - 1);
        }

        // Reverse the result to get the final negabinary number
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two negabinary arrays
        String[] input1 = scanner.nextLine().split(" ");
        String[] input2 = scanner.nextLine().split(" ");

        // Convert input to integer arrays
        int[] arr1 = Arrays.stream(input1).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(input2).mapToInt(Integer::parseInt).toArray();

        // Perform negabinary addition
        List<Integer> result = addNegabinary(arr1, arr2);

        // Print the result
        System.out.println(result);
        scanner.close();
    }
}
