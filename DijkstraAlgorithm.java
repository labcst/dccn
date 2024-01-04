import java.util.Scanner;

public class DijkstraAlgorithm {

    public void dijkstraAlgorithm(int[][] graph, int source) {
        int nodes = graph.length;
        boolean[] visited_vertex = new boolean[nodes];
        int[] dist = new int[nodes];

        for (int i = 0; i < nodes; i++) {
            visited_vertex[i] = false;
            dist[i] = Integer.MAX_VALUE;
        }

        dist[source] = 0;

        for (int i = 0; i < nodes; i++) {
            int u = find_min_distance(dist, visited_vertex);
            visited_vertex[u] = true;

            for (int v = 0; v < nodes; v++) {
                if (!visited_vertex[v] && graph[u][v] != 0 && (dist[u] + graph[u][v] < dist[v])) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println(String.format("Distance from Vertex %s to Vertex %s is %s", source, i, dist[i]));
        }
    }

    private static int find_min_distance(int[] dist, boolean[] visited_vertex) {
        int minimum_distance = Integer.MAX_VALUE;
        int minimum_distance_vertex = -1;

        for (int i = 0; i < dist.length; i++) {
            if (!visited_vertex[i] && dist[i] < minimum_distance) {
                minimum_distance = dist[i];
                minimum_distance_vertex = i;
            }
        }

        return minimum_distance_vertex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        System.out.print("Enter number of vertices : ");
        V = sc.nextInt();
        System.out.print("\nEnter number of edges : ");
        E = sc.nextInt();

        int g[][] = new int[V][V];

        for (int k = 0; k < E; k++) {
            System.out.print("\nEnter source, destination and weight of edge " + (k + 1) + " : ");
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;
            int w = sc.nextInt();
            g[i][j] = w;
        }

        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
        dijkstraAlgorithm.dijkstraAlgorithm(g, 0);

        sc.close();
    }
}
