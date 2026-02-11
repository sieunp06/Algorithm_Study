import java.io.*;
import java.util.*;

public class Main {
    private static int m, n;
    private static int[] parent;

    private static class Edge implements Comparable<Edge> {
        int start, end, weight;
        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        while (true) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            int n = Integer.parseInt(stringTokenizer.nextToken());

            if (m == 0 && n == 0) break;

            List<Edge> edges = new ArrayList<>();
            int total = 0;

            for (int i = 0; i < n; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());
                int z = Integer.parseInt(stringTokenizer.nextToken());

                edges.add(new Edge(x, y, z));
                total += z;
            }

            Collections.sort(edges);

            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            int mstCost = 0;

            for (Edge edge : edges) {
                if (union(edge.start, edge.end)) {
                    mstCost += edge.weight;
                }
            }

            System.out.println(total - mstCost);
        }
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;

        parent[rootB] = rootA;
        return true;
    }
}
