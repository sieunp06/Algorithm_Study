import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, s, e;
    private static List<Node>[] lists;
    private static int[] dist;

    private static class Node {
        int end, weight;
        Node(int end, int weight) {
            this.end = end;
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

        for (int i = 0; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());

            lists[start].add(new Node(end, weight));
            lists[end].add(new Node(start, weight));
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        s = Integer.parseInt(stringTokenizer.nextToken());
        e = Integer.parseInt(stringTokenizer.nextToken());

        dist = new int[N + 1];
        Arrays.fill(dist, 0);
        dijkstra(s);
        System.out.println(dist[e]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b.weight, a.weight));
        dist[start] = Integer.MAX_VALUE;
        priorityQueue.add(new Node(start, dist[start]));

        while (!priorityQueue.isEmpty()) {
            Node now = priorityQueue.poll();

            if (now.weight < dist[now.end]) continue;

            for (Node next : lists[now.end]) {
                int possible = Math.min(dist[now.end], next.weight);
                if (dist[next.end] < possible) {
                    dist[next.end] = possible;
                    priorityQueue.add(new Node(next.end, possible));
                }
            }
        }
    }
}
