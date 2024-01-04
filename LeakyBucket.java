import java.util.Scanner;

class LeakyBucket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int storage = 0;
        int no_of_queries, output_pkt_size;
        int input_pkt_size, bucket_size, size_left;

        System.out.print("Enter the total number of queries: ");
        no_of_queries = scanner.nextInt();

        System.out.print("Enter the bucket size: ");
        bucket_size = scanner.nextInt();

        System.out.print("Enter the input packet size: ");
        input_pkt_size = scanner.nextInt();

        System.out.print("Enter the output packet size: ");
        output_pkt_size = scanner.nextInt();

        for (int i = 0; i < no_of_queries; i++) {
            size_left = bucket_size - storage;

            if (input_pkt_size <= size_left) {
                storage += input_pkt_size;
            } else {
                System.out.println("Packet loss = " + (input_pkt_size - size_left));
                System.out.println("Buffer size = " + storage + " out of bucket size = " + bucket_size);
                storage = bucket_size;
            }

            storage -= output_pkt_size;
        }

        scanner.close();
    }
}
