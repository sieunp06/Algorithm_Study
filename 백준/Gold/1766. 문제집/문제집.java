import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M;
    private static List<Integer>[] graph;
    private static int[] inDegree;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        topologySearch();
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        graph = new List[N + 1];
        inDegree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());

            graph[A].add(B);
            inDegree[B]++;
        }
    }

    private static void topologySearch() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            stringBuilder.append(now).append(" ");
            for (int num : graph[now]) {
                inDegree[num]--;
                if (inDegree[num] == 0) {
                    queue.offer(num);
                }
            }
        }
    }
}
