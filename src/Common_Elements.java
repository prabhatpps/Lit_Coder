import java.util.Scanner;

public class Common_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the first array
        String[] firstInput = scanner.nextLine().split(" ");
        int n1 = firstInput.length;
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = Integer.parseInt(firstInput[i]);
        }

        // Read the second array
        String[] secondInput = scanner.nextLine().split(" ");
        int n2 = secondInput.length;
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = Integer.parseInt(secondInput[i]);
        }

        // Read the third array
        String[] thirdInput = scanner.nextLine().split(" ");
        int n3 = thirdInput.length;
        int[] arr3 = new int[n3];
        for (int i = 0; i < n3; i++) {
            arr3[i] = Integer.parseInt(thirdInput[i]);
        }

        // Initialize pointers for the three arrays
        int i = 0, j = 0, k = 0;
        boolean foundCommon = false;

        // Traverse the arrays
        while (i < n1 && j < n2 && k < n3) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                System.out.print(arr1[i] + " ");
                foundCommon = true;
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }

        // If no common elements were found
        if (!foundCommon) {
            System.out.println("No Elements");
        }

        scanner.close();
    }
}
