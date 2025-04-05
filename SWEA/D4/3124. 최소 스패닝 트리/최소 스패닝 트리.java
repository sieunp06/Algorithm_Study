import java.io.*;
import java.util.*;

public class Solution {
    static int V, E;
    static boolean[] visited;
    static List<Edge>[] adjList;

    static class Edge implements Comparable<Edge> {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            stringBuilder.append("#").append(testCase).append(" ").append(prim()).append("\n");
        }
        System.out.println(stringBuilder);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        V = Integer.parseInt(stringTokenizer.nextToken());
        E = Integer.parseInt(stringTokenizer.nextToken());

        adjList = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());

            adjList[from].add(new Edge(to, weight));
            adjList[to].add(new Edge(from, weight));
        }
        visited = new boolean[V + 1];
    }

    static long prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        long totalWeight = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (visited[now.to]) continue;

            visited[now.to] = true;
            totalWeight += now.weight;
            count++;

            if (count == V) break;

            for (Edge edge : adjList[now.to]) {
                if (!visited[edge.to])  {
                    pq.offer(edge);
                }
            }
        }
        return totalWeight;
    }
}
