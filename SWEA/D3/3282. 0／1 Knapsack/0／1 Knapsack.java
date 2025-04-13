import java.io.*;
import java.util.*;

public class Solution {
    static int N, K;
    static int[] Vs, Cs;

    static int[][] dp;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            stringBuilder.append("#").append(testCase).append(" ").append(find()).append("\n");
        }
        System.out.print(stringBuilder);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        Vs = new int[N + 1];
        Cs = new int[N + 1];

        dp = new int[N + 1][K + 1];

        for (int j = 1; j <= N; j++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            Vs[j] = Integer.parseInt(stringTokenizer.nextToken());
            Cs[j] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    static int find() {
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= Vs[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - Vs[i]] + Cs[i]);
                }
            }
        }
        return dp[N][K];
    }
}
