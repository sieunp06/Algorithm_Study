import java.io.*;
import java.util.*;

public class Main {
    private static int N, R, Q;
    private static List<Integer>[] lists;
    private static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        R = Integer.parseInt(stringTokenizer.nextToken());
        Q = Integer.parseInt(stringTokenizer.nextToken());

        lists = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int U = Integer.parseInt(stringTokenizer.nextToken());
            int V = Integer.parseInt(stringTokenizer.nextToken());

            lists[U].add(V);
            lists[V].add(U);
        }

        dp = new int[N + 1];
        count(R, 0);

        for (int i = 0; i < Q; i++) {
            int U = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(dp[U]).append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static void count(int root, int parent) {
        dp[root] = 1;

        for (int v : lists[root]) {
            if (v == parent) {
                continue;
            }
            count(v, root);
            dp[root] += dp[v];
        }
    }
}
