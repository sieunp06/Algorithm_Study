import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[N + 1];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        boolean[][] dp = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }

        for (int i = 1; i < N; i++) {
            if (numbers[i] == numbers[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        for (int len = 3; len <= N; len++) {
            for (int i = 1; i + len - 1 <= N; i++) {
                int j = i + len - 1;
                if (numbers[i] == numbers[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        int M = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int S = Integer.parseInt(stringTokenizer.nextToken());
            int E = Integer.parseInt(stringTokenizer.nextToken());

            stringBuilder.append(dp[S][E] ? 1: 0).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
