import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M;

    private static List<Integer>[] graph;
    private static int[] inDegree;

    private static List<Integer> result;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        topologySort();
        printResult();
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());  // 가수의 수
        M = Integer.parseInt(stringTokenizer.nextToken());  // 보조 PC의 수

        graph = new List[N + 1];
        inDegree = new int[N + 1];

        result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int numOfSinger = Integer.parseInt(stringTokenizer.nextToken());
            int singer = Integer.parseInt(stringTokenizer.nextToken());

            for (int j = 0; j < numOfSinger - 1; j++) {
                int target = Integer.parseInt(stringTokenizer.nextToken());
                graph[singer].add(target);
                singer = target;
                inDegree[target]++;
            }
        }
    }

    private static void topologySort() {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            result.add(now);

            for (int num : graph[now]) {
                inDegree[num]--;
                if (inDegree[num] == 0) {
                    queue.offer(num);
                }
            }
        }
    }

    private static void printResult() {
        if (result.size() != N) {
            System.out.println(0);
            return;
        }
        for (int num : result) {
            System.out.println(num);
        }
    }
}