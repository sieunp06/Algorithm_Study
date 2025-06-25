import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int N, M, from, to;
    private static List<Node>[] nodes;
    private static int[] dist;
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
        System.out.println(dijkstra(from));
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        M = Integer.parseInt(bufferedReader.readLine());

        nodes = new List[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int cost = Integer.parseInt(stringTokenizer.nextToken());

            nodes[from].add(new Node(to, cost));
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        from = Integer.parseInt(stringTokenizer.nextToken());
        to = Integer.parseInt(stringTokenizer.nextToken());
    }

    private static int dijkstra(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(start, 0));
        dist[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            if (node.to == to) return dist[to];
            if (node.cost > dist[node.to]) continue;

            for (Node next : nodes[node.to]) {
                if (dist[next.to] > dist[node.to] + next.cost) {
                    dist[next.to] = dist[node.to] + next.cost;
                    priorityQueue.add(new Node(next.to, dist[next.to]));
                }
            }
        }

        return dist[to];
    }
}
