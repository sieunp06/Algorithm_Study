import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int[][] dp = new int[41][2]; // 0~40까지

    public static void main(String[] args) throws IOException {
        initDP();

        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }

        System.out.print(stringBuilder);
    }

    static void initDP() {
        dp[0][0] = 1;
        dp[0][1] = 0;

        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
    }
}
