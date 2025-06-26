import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int N, M, X;
    private static List<Node>[] graph;
    private static List<Node>[] reverseGraph;
    private static int[] distance;
    private static final int INF = Integer.MAX_VALUE;

    private static class Node implements Comparable<Node> {
        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        int[] distTo = dijkstra(X, graph);
        int[] distFrom = dijkstra(X, reverseGraph);

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (distTo[i] == INF || distFrom[i] == INF) continue;
            answer = Math.max(answer, distTo[i] + distFrom[i]);
        }
        System.out.println(answer);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        X = Integer.parseInt(stringTokenizer.nextToken());

        graph = new List[N + 1];
        reverseGraph = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int cost = Integer.parseInt(stringTokenizer.nextToken());

            graph[from].add(new Node(to, cost));
            reverseGraph[to].add(new Node(from, cost));
        }
    }

    private static int[] dijkstra(int start, List<Node>[] nodes) {
        distance = new int[N + 1];
        Arrays.fill(distance, INF);

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(start, 0));
        distance[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node now = priorityQueue.poll();

            if (now.cost > distance[now.to]) continue;

            for (Node node : nodes[now.to]) {
                if (distance[node.to] > distance[now.to] + node.cost) {
                    distance[node.to] = distance[now.to] + node.cost;
                    priorityQueue.add(new Node(node.to, distance[node.to]));
                }
            }
        }
        return distance;
    }
}
