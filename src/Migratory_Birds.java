import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Migratory_Birds {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the input line and split it into tokens
        String input = sc.nextLine();
        String[] tokens = input.split(" ");

        // Use a HashMap to count occurrences of each plant ID
        Map<Integer, Integer> plantCount = new HashMap<>();

        // Count the occurrences of each plant ID
        for (String token : tokens) {
            int plantID = Integer.parseInt(token);
            plantCount.put(plantID, plantCount.getOrDefault(plantID, 0) + 1);
        }

        // Variables to keep track of the most common plant ID and its count
        int mostCommonPlantID = Integer.MAX_VALUE;
        int maxCount = 0;

        // Determine the most common plant ID
        for (Map.Entry<Integer, Integer> entry : plantCount.entrySet()) {
            int plantID = entry.getKey();
            int count = entry.getValue();

            // Check if we found a more common plant or a tie with a smaller ID
            if (count > maxCount || (count == maxCount && plantID < mostCommonPlantID)) {
                mostCommonPlantID = plantID;
                maxCount = count;
            }
        }

        // Print the most common plant ID
        System.out.println(mostCommonPlantID);

        sc.close();
    }
}
