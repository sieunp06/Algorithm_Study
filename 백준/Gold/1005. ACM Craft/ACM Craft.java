import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int T;   // 테스트 케이스의 개수
    private static int N, K;
    private static int W;
    private static int[] buildings;

    private static List<Integer>[] constructions;
    private static int[] inDegree;
    private static int[] dp;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            topologySort();
            System.out.println(dp[W]);
        }
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());  // 건물의 개수
        K = Integer.parseInt(stringTokenizer.nextToken());  // 건설 순서 규칙의 총 개수

        dp = new int[N + 1];
        buildings = new int[N + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= N; i++) {
            int weight = Integer.parseInt(stringTokenizer.nextToken());
            buildings[i] = weight;
            dp[i] = weight;
        }

        constructions = new List[N + 1];
        inDegree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            constructions[i] = new ArrayList<>();
        }

        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());

            constructions[A].add(B);
            inDegree[B]++;
        }
        W = Integer.parseInt(bufferedReader.readLine());
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
            for (int num : constructions[now]) {
                dp[num] = Math.max(dp[num], dp[now] + buildings[num]);
                inDegree[num]--;
                if (inDegree[num] == 0) {
                    queue.offer(num);
                }
            }
        }
    }
}
