import java.util.PriorityQueue;
import java.util.Scanner;

public class Cookies{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the target sweetness level
        int target = scanner.nextInt();

        // Read the candy sweetness values
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        while (scanner.hasNextInt()) {
            minHeap.add(scanner.nextInt());
        }

        System.out.println(minStepsToReachTarget(minHeap, target));
    }

    // Function to calculate minimum steps to reach the target sweetness
    public static int minStepsToReachTarget(PriorityQueue<Integer> minHeap, int target) {
        int steps = 0;

        // Continue until the smallest element in the heap meets the target sweetness
        while (minHeap.size() > 1 && minHeap.peek() < target) {
            // Get the two least sweet candies
            int first = minHeap.poll();
            int second = minHeap.poll();

            // Combine them to create a new candy
            int newSweetness = first + 2 * second;

            // Add the new candy back to the heap
            minHeap.add(newSweetness);

            // Increment the step counter
            steps++;
        }

        // Check if we reached the target sweetness
        if (minHeap.peek() >= target) {
            return steps;
        } else {
            return -1; // If it's impossible to reach the target
        }
    }
}