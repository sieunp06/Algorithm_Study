import java.io.*;
import java.util.*;

public class Main {
    private static int n, m, k;
    private static List<Node>[] lists;
    private static PriorityQueue<Integer>[] answer;

    private static class Node implements Comparable<Node> {
        int to, weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());

        lists = new List[n + 1];
        answer = new PriorityQueue[n + 1];
        for (int i  = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
            answer[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            lists[a].add(new Node(b, c));
        }

        dijkstra(1);
        for (int i = 1; i <= n; i++) {
            stringBuilder.append(answer[i].size() < k ? -1 : answer[i].peek()).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(start, 0));
        answer[start].add(0);

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            for (Node next : lists[node.to]) {
                int cost = node.weight + next.weight;
                if (answer[next.to].size() < k) {
                    answer[next.to].add(cost);
                    priorityQueue.add(new Node(next.to, cost));
                } else if (answer[next.to].peek() > cost) {
                    answer[next.to].poll();
                    answer[next.to].add(cost);
                    priorityQueue.add(new Node(next.to, cost));
                }
            }
        }
    }
}
