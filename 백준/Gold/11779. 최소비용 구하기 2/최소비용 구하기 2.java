import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    private static int N, M, start, end;
    private static List<Node>[] graph;
    private static int[] distance, prev;

    private static final int INF = Integer.MAX_VALUE;

    private static class Node implements Comparable<Node> {
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

    public static void main(String[] args) throws IOException {
        init();
        dijkstra();
        printResult();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        M = Integer.parseInt(bufferedReader.readLine());

        graph = new List[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, INF);
        prev = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int cost = Integer.parseInt(stringTokenizer.nextToken());

            graph[from].add(new Node(to, cost));
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        start = Integer.parseInt(stringTokenizer.nextToken());
        end = Integer.parseInt(stringTokenizer.nextToken());
    }

    private static void dijkstra() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(start, 0));
        distance[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            if (distance[node.to] < node.cost) continue;

            for (Node next : graph[node.to]) {
                if (distance[next.to] > distance[node.to] + next.cost) {
                    distance[next.to] = distance[node.to] + next.cost;
                    prev[next.to] = node.to;
                    priorityQueue.add(new Node(next.to, distance[next.to]));
                }
            }
        }
    }

    private static void printResult() {
        stringBuilder.append(distance[end]).append("\n");
        List<Integer> path = new ArrayList<>();
        for (int curr = end; curr != 0; curr = prev[curr]) {
            path.add(curr);
        }
        Collections.reverse(path);

        stringBuilder.append(path.size()).append("\n");
        for (int city : path) {
            stringBuilder.append(city).append(" ");
        }

        System.out.println(stringBuilder);
    }
}
