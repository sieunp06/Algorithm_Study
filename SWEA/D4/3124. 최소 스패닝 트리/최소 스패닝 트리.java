import java.io.*;
import java.util.*;

public class Solution {
    static int V, E;
    static int[] parent;
    static PriorityQueue<Edge> edgeList;

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));;
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int tc = 1; tc <= T; tc++) {
            stringBuilder.append("#").append(tc).append(" ");
            init();
            stringBuilder.append(kruskal()).append("\n");
        }

        System.out.print(stringBuilder);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        V = Integer.parseInt(stringTokenizer.nextToken());
        E = Integer.parseInt(stringTokenizer.nextToken());

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        edgeList = new PriorityQueue<>();

        for (int i = 0; i < E; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());
            edgeList.add(new Edge(from, to, weight));
        }
    }

    static long kruskal() {
        long totalWeight = 0;
        int count = 0;

        while (!edgeList.isEmpty()) {
            Edge e = edgeList.poll();

            if (union(e.from, e.to)) {
                totalWeight += e.weight;
                if (++count == V - 1) break;
            }
        }

        return totalWeight;
    }

    static int find(int x) {
        if (x != parent[x])
            parent[x] = find(parent[x]);
        return parent[x];
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;

        parent[rootB] = rootA;
        return true;
    }
}
