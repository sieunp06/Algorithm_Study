import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E, K;
    static List<Node>[] nodes;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int v, w;

        Node (int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        dijkstra(K);
        printResult();
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        V = Integer.parseInt(stringTokenizer.nextToken());  // 정점의 개수
        E = Integer.parseInt(stringTokenizer.nextToken());  // 간선의 개수

        K = Integer.parseInt(bufferedReader.readLine());

        nodes = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            nodes[i] = new ArrayList<>();
        }

        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < E; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            int w = Integer.parseInt(stringTokenizer.nextToken());

            nodes[u].add(new Node(v, w));
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            int cur = now.v;
            int w = now.w;

            if (w > dist[cur]) continue;

            for (Node node : nodes[cur]) {
                if (dist[node.v] > dist[cur] + node.w) {
                    dist[node.v] = dist[cur] + node.w;
                    pq.offer(new Node(node.v, dist[node.v]));
                }
            }
        }
    }

    static void printResult() {
        for (int i = 1; i <= V; i++) {
            stringBuilder.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
