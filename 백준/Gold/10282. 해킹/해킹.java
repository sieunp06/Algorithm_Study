import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    private static List<Computer>[] computers;
    private static int[] dist;
    private static final int INF = Integer.MAX_VALUE;

    private static class Computer {
        int to, time;
        Computer(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        while (T --> 0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int d = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            computers = new List[n + 1];

            for (int i = 1; i <= n; i++) {
                computers[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());
                int s = Integer.parseInt(stringTokenizer.nextToken());

                computers[b].add(new Computer(a, s));
            }

            dist = new int[n + 1];
            Arrays.fill(dist, INF);
            dijkstra(c);

            int count = 0;
            int time = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] != INF) {
                    count++;
                    time = Math.max(time, dist[i]);
                }
            }
            stringBuilder.append(count).append(" ").append(time).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Computer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(v -> v.time));
        priorityQueue.add(new Computer(start, 0));
        dist[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Computer computer = priorityQueue.poll();

            if (dist[computer.to] == INF) continue;

            for (Computer c : computers[computer.to]) {
                if (dist[c.to] > dist[computer.to] + c.time) {
                    dist[c.to] = dist[computer.to] + c.time;
                    priorityQueue.add(new Computer(c.to, dist[c.to]));
                }
            }
        }
    }
}
