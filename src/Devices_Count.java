import java.util.Scanner;

public class Devices_Count {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for total available hours
        int availableHours = scanner.nextInt();

        // Input for the number of devices to be tested
        int totalDevices = scanner.nextInt();

        // Each device requires 4 hours to be tested
        int hoursPerDevice = 4;

        // If available hours are less than 4, it's an invalid input
        if (availableHours < hoursPerDevice) {
            System.out.println("Invalid Input");
        } else {
            // Calculate how many devices can be tested in the given time
            int devicesTested = availableHours / hoursPerDevice;

            // Check if we can test more devices than available
            if (devicesTested >= totalDevices) {
                System.out.println(totalDevices);
                System.out.println(0); // All devices are tested
            } else {
                // Some devices are left untested
                System.out.println(devicesTested);
                System.out.println(totalDevices - devicesTested);
            }
        }
        scanner.close();
    }
}
