import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N, M;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        init();
        printResult();
        System.out.print(stringBuilder);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
    }

    private static void printResult() {
        int minSum = Integer.MAX_VALUE;
        int resultNode = 0;

        for (int i = 1; i <= N; i++) {
            int totalDistance = bfs(i);
            if (totalDistance < minSum) {
                minSum = totalDistance;
                resultNode = i;
            }
        }

        stringBuilder.append(resultNode).append("\n");
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += distance[i];
        }
        return sum;
    }
}
