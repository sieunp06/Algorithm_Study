import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int V, E, K;
    private static final int INF = Integer.MAX_VALUE;
    private static List<Node>[] graph;
    private static int[] distance;

    private static class Node implements Comparable<Node> {
        int v, w;
        Node (int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        dijkstra(K);
        printResult();
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        V = Integer.parseInt(stringTokenizer.nextToken());
        E = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(bufferedReader.readLine());

        graph = new List[V + 1];
        distance = new int[V + 1];
        Arrays.fill(distance, INF);

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            int w = Integer.parseInt(stringTokenizer.nextToken());

            graph[u].add(new Node(v, w));
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Node(start, 0));
        distance[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node now = priorityQueue.poll();

            if (now.w > distance[now.v]) continue;

            for (Node next : graph[now.v]) {
                if (distance[next.v] > distance[now.v] + next.w) {
                    distance[next.v] = distance[now.v] + next.w;
                    priorityQueue.offer(new Node(next.v, distance[next.v]));
                }
            }
        }
    }

    private static void printResult() {
        for (int i = 1; i <= V; i++) {
            stringBuilder.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]).append("\n");
        }
        System.out.print(stringBuilder);
    }
}
