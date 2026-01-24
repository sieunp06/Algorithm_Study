import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[][] numbers = new int[2][n];
            int[][] dp = new int[2][n];

            for (int i = 0; i < 2; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < n; j++) {
                    numbers[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            if (n == 1) {
                System.out.println(Math.max(numbers[0][0], numbers[1][0]));
                continue;
            }

            dp[0][0] = numbers[0][0];
            dp[1][0] = numbers[1][0];
            dp[0][1] = dp[1][0] + numbers[0][1];
            dp[1][1] = dp[0][0] + numbers[1][1];

            for (int j = 2; j < n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + numbers[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + numbers[1][j];
            }

            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
        }
    }
}
