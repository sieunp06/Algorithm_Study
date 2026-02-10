import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] cost = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            cost[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            cost[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            cost[i][2] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int INF = 1_000_000_000;
        int answer = INF;
        for (int first = 0; first < 3; first++) {
            int[][] dp = new int[N + 1][3];

            for (int c = 0; c < 3; c++) {
                dp[1][c] = (c == first) ? cost[1][c] : INF;
            }

            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
            }

            for (int c = 0; c < 3; c++) {
                if (c != first) {
                    answer = Math.min(answer, dp[N][c]);
                }
            }
        }
        System.out.println(answer);
    }
}
