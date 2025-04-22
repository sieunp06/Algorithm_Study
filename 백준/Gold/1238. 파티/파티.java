import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, X;
    static List<Node>[] nodes, nodesReverse;
    static int[] answer;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int to, cost;
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();

        int[] distTo = solve(X, nodes);
        int[] distFrom = solve(X, nodesReverse);

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (distTo[i] == INF || distFrom[i] == INF) continue;
            answer = Math.max(answer, distTo[i] + distFrom[i]);
        }
        System.out.println(answer);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        X = Integer.parseInt(stringTokenizer.nextToken());

        nodes = new List[N + 1];
        nodesReverse = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
            nodesReverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int cost = Integer.parseInt(stringTokenizer.nextToken());

            nodes[from].add(new Node(to, cost));
            nodesReverse[to].add(new Node(from, cost));
        }
    }

    static int[] solve(int start, List<Node>[] nodes) {
        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            int to = now.to;
            int cost = now.cost;

            if (cost > dist[to]) continue;

            for (Node node : nodes[to]) {
                if (dist[node.to] > dist[to] + node.cost) {
                    dist[node.to] = dist[to] + node.cost;
                    pq.offer(new Node(node.to, dist[node.to]));
                }
            }
        }
        return dist;
    }
}