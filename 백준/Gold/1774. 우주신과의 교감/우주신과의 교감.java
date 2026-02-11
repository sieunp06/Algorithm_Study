import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] parent;
    private static List<God> gods = new ArrayList<>();
    private static List<Edge> edges = new ArrayList<>();

    private static class God {
        double X, Y;
        God(double X, double Y) {
            this.X = X;
            this.Y = Y;
        }
    }

    private static class Edge implements Comparable<Edge> {
        int start, end;
        double weight;
        Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        parent = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int X = Integer.parseInt(stringTokenizer.nextToken());
            int Y = Integer.parseInt(stringTokenizer.nextToken());

            gods.add(new God(X, Y));
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                God a = gods.get(i);
                God b = gods.get(j);

                double dx = a.X - b.X;
                double dy = a.Y - b.Y;
                double dist = Math.sqrt(dx * dx + dy * dy);

                edges.add(new Edge(i, j, dist));
            }
        }

        Collections.sort(edges);

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int b = Integer.parseInt(stringTokenizer.nextToken()) - 1;

            union(a, b);
        }

        double weight = 0;
        int count = 0;

        for (Edge edge : edges) {
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                weight += edge.weight;
                count++;
            }
            if (count == N - 1) {
                break;
            }
        }

        System.out.printf("%.2f\n", weight);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
         int rootA = find(a);
         int rootB = find(b);

         if (rootA != rootB) {
             parent[rootB] = rootA;
         }
    }
}
