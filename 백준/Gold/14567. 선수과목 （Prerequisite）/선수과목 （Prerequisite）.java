import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static List<Integer>[] graph;
    private static int[] inDegree;
    private static int[] answer;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        topologySort();
        printAnswer();
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        graph = new List[N + 1];
        inDegree = new int[N + 1];
        answer = new int[N + 1];

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

    private static void topologySort() {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                answer[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int num : graph[now]) {
                inDegree[num]--;
                if (inDegree[num] == 0) {
                    answer[num] = answer[now] + 1;
                    queue.add(num);
                }
            }
        }
    }

    private static void printAnswer() {
        for (int i = 1; i <= N; i++) {
            stringBuilder.append(answer[i]).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
