import java.util.*;

public class Single_And_Pair_Sorting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of input lines
        int numInputs = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // Lists to store single integers and pairs
        List<Integer> singleIntegers = new ArrayList<>();
        List<int[]> pairs = new ArrayList<>();

        // Process each input line
        for (int i = 0; i < numInputs; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ");

            // Check if it's a pair or a single integer
            if (parts.length == 1) {
                // It's a single integer
                singleIntegers.add(Integer.parseInt(parts[0]));
            } else if (parts.length == 2) {
                // It's a pair
                int[] pair = { Integer.parseInt(parts[0]), Integer.parseInt(parts[1]) };
                pairs.add(pair);
            }
        }

        // Sort the single integers
        Collections.sort(singleIntegers);

        // Sort the pairs by the first element
        pairs.sort(Comparator.comparingInt(a -> a[0]));

        // Output sorted single integers
        for (int num : singleIntegers) {
            System.out.println(num);
        }

        // Output sorted pairs
        for (int[] pair : pairs) {
            System.out.println(pair[0] + " " + pair[1]);
        }

        scanner.close();
    }
}
