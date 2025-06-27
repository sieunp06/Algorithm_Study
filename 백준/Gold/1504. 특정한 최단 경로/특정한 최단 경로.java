import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    private static int N, E, v1, v2;
    private static List<Node>[] nodes;
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
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        int path1 = addIfPossible(
                dijkstra(1, v1),
                dijkstra(v1, v2),
                dijkstra(v2, N)
        );

        int path2 = addIfPossible(
                dijkstra(1, v2),
                dijkstra(v2, v1),
                dijkstra(v1, N)
        );

        int result = Math.min(path1, path2);
        System.out.println(result == INF ? -1 : result);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        E = Integer.parseInt(stringTokenizer.nextToken());

        nodes = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            nodes[a].add(new Node(b, c));
            nodes[b].add(new Node(a, c));
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        v1 = Integer.parseInt(stringTokenizer.nextToken());
        v2 = Integer.parseInt(stringTokenizer.nextToken());
    }

    private static int dijkstra(int start, int end) {
        distance = new int[N + 1];
        Arrays.fill(distance, INF);

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(start, 0));
        distance[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            if (node.cost > distance[node.to]) continue;
            for (Node next : nodes[node.to]) {
                if (distance[next.to] > distance[node.to] + next.cost) {
                    distance[next.to] = distance[node.to] + next.cost;
                    priorityQueue.add(new Node(next.to, distance[next.to]));
                }
            }
        }

        return distance[end];
    }

    private static int addIfPossible(int a, int b, int c) {
        if (a == INF || b == INF || c == INF) return INF;
        return a + b + c;
    }
}
