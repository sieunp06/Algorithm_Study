import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    private static int N, M, K, X;
    private static List<Integer>[] graph;
    private static int[] distance;

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        printResult();
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        X = Integer.parseInt(stringTokenizer.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());
            graph[A].add(B);
        }

        distance = new int[N + 1];
        Arrays.fill(distance, -1);
        distance[X] = 0;
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(X);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }
    }

    private static void printResult() {
        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                stringBuilder.append(i).append("\n");
                found = true;
            }
        }

        System.out.println(found ? stringBuilder : -1);
    }
}
