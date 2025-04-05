import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] T, P;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.println(getMaxProfit());
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];
        dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        for (int i = 1; i <= N; i++) {
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            if (i + T[i] <= N + 1) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
        }
    }

    static int getMaxProfit() {
        int max = 0;
        for (int i = 1; i <= N + 1; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
