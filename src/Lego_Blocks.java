import java.util.*;

public class Lego_Blocks {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Height of the wall
        int m = scanner.nextInt(); // Width of the wall

        System.out.println(legoWall(n, m));
    }

    // Function to calculate the number of ways to build the wall
    public static int legoWall(int n, int m) {
        // Step 1: Calculate the number of ways to build a row of width m
        int[] waysRow = new int[m + 1];
        waysRow[0] = 1; // Base case: One way to build a row of width 0

        // Fill the waysRow array using dynamic programming
        for (int i = 1; i <= m; i++) {
            waysRow[i] = waysRow[i - 1]; // Place a brick of width 1
            if (i >= 2) waysRow[i] = (waysRow[i] + waysRow[i - 2]) % MOD;
            if (i >= 3) waysRow[i] = (waysRow[i] + waysRow[i - 3]) % MOD;
            if (i >= 4) waysRow[i] = (waysRow[i] + waysRow[i - 4]) % MOD;
        }

        // Step 2: Calculate total ways to build the wall without considering breaks
        long totalWays = modPow(waysRow[m], n, MOD);

        // Step 3: Calculate the number of valid walls (removing invalid vertical breaks)
        long[] solidWays = new long[m + 1];
        solidWays[0] = 1; // Base case: One way to build a solid wall of width 0

        for (int width = 1; width <= m; width++) {
            solidWays[width] = modPow(waysRow[width], n, MOD);
            for (int k = 1; k < width; k++) {
                solidWays[width] = (solidWays[width] - (solidWays[k] * waysRow[width - k]) % MOD + MOD) % MOD;
            }
        }

        return (int) solidWays[m];
    }

    // Function to perform modular exponentiation: (base^exp) % mod
    private static long modPow(long base, int exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;

    }
}