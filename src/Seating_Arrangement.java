import java.util.*;

public class Seating_Arrangement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read total number of students and row count
        int totalStudents = scanner.nextInt();
        int rowCount = scanner.nextInt();

        // Input validation
        if (totalStudents < 1 || totalStudents > 100 || rowCount < 1 || rowCount > totalStudents) {
            System.out.println("Invalid input");
            return;
        }

        // Read student data (name and height)
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < totalStudents; i++) {
            String name = scanner.next();
            int height = scanner.nextInt();
            if (height < 1 || height > 200) {
                System.out.println("Enter valid height");
                return;
            }
            students.add(new Student(name, height));
        }

        // Sort students by height
        students.sort(Comparator.comparingInt(student -> student.height));

        // Generate all possible seating arrangements
        List<List<Integer>> possibleArrangements = generateRowConfigurations(totalStudents, rowCount);

        if (possibleArrangements.isEmpty()) {
            System.out.println("Not Possible to arrange");
        } else {
            for (List<Integer> arrangement : possibleArrangements) {
                printArrangement(students, arrangement);
            }
        }

        scanner.close();
    }

    // A class to represent a student with name and height
    static class Student {
        String name;
        int height;

        Student(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }

    // Generate all possible row configurations that follow the rule of increasing row size
    static List<List<Integer>> generateRowConfigurations(int totalStudents, int rowCount) {
        List<List<Integer>> configurations = new ArrayList<>();
        generateConfigurationsHelper(totalStudents, rowCount, new ArrayList<>(), 1, configurations);
        return configurations;
    }

    // Helper function to recursively generate valid row configurations
    static void generateConfigurationsHelper(int remainingStudents, int remainingRows, List<Integer> currentConfig, int minSize, List<List<Integer>> result) {
        if (remainingRows == 0) {
            if (remainingStudents == 0) {
                result.add(new ArrayList<>(currentConfig));
            }
            return;
        }

        // Try different row sizes from minSize to ensure increasing row sizes
        for (int i = minSize; i <= remainingStudents - remainingRows + 1; i++) {
            currentConfig.add(i);
            generateConfigurationsHelper(remainingStudents - i, remainingRows - 1, currentConfig, i + 1, result);
            currentConfig.remove(currentConfig.size() - 1); // backtrack
        }
    }

    // Print the seating arrangement based on a specific configuration
    static void printArrangement(List<Student> students, List<Integer> arrangement) {
        int start = 0;
        for (int rowSize : arrangement) {
            for (int i = 0; i < rowSize; i++) {
                System.out.print(students.get(start + i).name + " ");
            }
            start += rowSize;
            System.out.println();
        }
        System.out.println(); // Print a new line after each arrangement
    }
}
