import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] map;
    private static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];
        dp = new int[N][N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        dp[0][1][0] = 1;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {

                if (map[r][c] == 1) continue;

                // 가로
                if (c - 1 >= 0) {
                    dp[r][c][0] += dp[r][c - 1][0];
                    dp[r][c][0] += dp[r][c - 1][2];
                }

                // 세로
                if (r - 1 >= 0) {
                    dp[r][c][1] += dp[r - 1][c][1];
                    dp[r][c][1] += dp[r - 1][c][2];
                }

                // 대각선
                if (r - 1 >= 0 && c - 1 >= 0) {
                    if (map[r - 1][c] == 0 && map[r][c - 1] == 0) {
                        dp[r][c][2] += dp[r - 1][c - 1][0];
                        dp[r][c][2] += dp[r - 1][c - 1][1];
                        dp[r][c][2] += dp[r - 1][c - 1][2];
                    }
                }
            }
        }

        int result =
                dp[N - 1][N - 1][0]
                        + dp[N - 1][N - 1][1]
                        + dp[N - 1][N - 1][2];

        System.out.println(result);
    }
}
