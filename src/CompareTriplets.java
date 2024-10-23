import java.util.Scanner;

public class CompareTriplets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read Charlie's scores
        String charlieInput = scanner.nextLine();
        String[] charlieScores = charlieInput.split(" ");
        int[] charlie = new int[charlieScores.length];
        for (int i = 0; i < charlieScores.length; i++) {
            charlie[i] = Integer.parseInt(charlieScores[i]);
        }

        // Read Dave's scores
        String daveInput = scanner.nextLine();
        String[] daveScores = daveInput.split(" ");
        int[] dave = new int[daveScores.length];
        for (int i = 0; i < daveScores.length; i++) {
            dave[i] = Integer.parseInt(daveScores[i]);
        }

        // Calculate the comparison points
        int charliePoints = 0;
        int davePoints = 0;

        for (int i = 0; i < charlie.length; i++) {
            if (charlie[i] > dave[i]) {
                charliePoints++;
            } else if (charlie[i] < dave[i]) {
                davePoints++;
            }
            // If equal, do nothing
        }

        // Output the results
        System.out.println(charliePoints + " " + davePoints);
    }
}
