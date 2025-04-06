import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static int[][] cost;
    static int[][] dp;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(dp());
    }

    static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());

        cost = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            cost[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            cost[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            cost[i][2] = Integer.parseInt(stringTokenizer.nextToken());
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
    }

    static int dp() {
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
        }

        return Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2]));
    }
}
