import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static List<Node>[] lists;
    private static int[] dist;
    private static final int INF = Integer.MAX_VALUE;

    private static class Node {
        int to, weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        lists = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            lists[a].add(new Node(b, c));
            lists[b].add(new Node(a, c));
        }

        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dijkstra();
        System.out.println(dist[N]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(v -> v.weight));
        priorityQueue.add(new Node(1, 0));
        dist[1] = 0;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            for (Node next : lists[node.to]) {
                if (dist[next.to] > dist[node.to] + next.weight) {
                    dist[next.to] = dist[node.to] + next.weight;
                    priorityQueue.add(new Node(next.to, dist[next.to]));
                }
            }
        }
    }
}
