import java.net.*;
import java.util.Scanner;

public class SimpleDNS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n Menu: \n 1. DNS Lookup 2. Reverse DNS Lookup 3. Exit \n");
            System.out.println("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        performDNSLookup(scanner);
                        break;
                    case 2:
                        performReverseDNSLookup(scanner);
                        break;
                    case 3:
                        System.out.println("Exiting the program. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }

    private static void performDNSLookup(Scanner scanner) {
        System.out.println("\nEnter Host Name: ");
        String hostName = scanner.nextLine();

        try {
            InetAddress address = InetAddress.getByName(hostName);
            System.out.println("Host Name: " + address.getHostName());
            System.out.println("IP Address: " + address.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + hostName);
        }
    }

    private static void performReverseDNSLookup(Scanner scanner) {
        System.out.println("\nEnter IP Address: ");
        String ipAddress = scanner.nextLine();

        try {
            InetAddress ia = InetAddress.getByName(ipAddress);
            System.out.println("IP Address: " + ipAddress);
            System.out.println("Host Name: " + ia.getHostName());
        } catch (UnknownHostException e) {
            System.out.println("Unknown host for IP: " + ipAddress);
        }
    }
}

