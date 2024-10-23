import java.util.Scanner;

public class Transform_and_Compare {

    public static boolean canTransform(String start, String end) {
        // Check character counts
        if (countChar(start, 'L') != countChar(end, 'L') ||
                countChar(start, 'R') != countChar(end, 'R') ||
                countChar(start, 'X') != countChar(end, 'X')) {
            return false;
        }

        int i = 0, j = 0;
        while (i < start.length() && j < end.length()) {
            // Skip 'X' in both strings
            while (i < start.length() && start.charAt(i) == 'X') {
                i++;
            }
            while (j < end.length() && end.charAt(j) == 'X') {
                j++;
            }

            // If we reach the end of one string before the other, return false
            if ((i < start.length()) != (j < end.length())) {
                return false;
            }

            // Check if the characters at the current position are the same
            if (i < start.length() && j < end.length()) {
                if (start.charAt(i) != end.charAt(j)) {
                    return false;
                }
            }

            // Move to the next character
            i++;
            j++;
        }

        return true;
    }

    private static int countChar(String str, char ch) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for the start and end strings
        String start = scanner.nextLine();

        String end = scanner.nextLine();

        // Call the transformation function and print the result
        boolean result = canTransform(start, end);
        System.out.println(result);

        scanner.close();
    }
}
                                                                                                                            