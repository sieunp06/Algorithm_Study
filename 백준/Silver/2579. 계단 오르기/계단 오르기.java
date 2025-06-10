import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N;
    static int[] stairs;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.println(dp[N]);
    }

    static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        stairs = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(bufferedReader.readLine());
        }
    }

    static void solve() {
        if (N == 1) {
            dp[1] = stairs[1];
            return;
        }

        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
        }
    }
}
