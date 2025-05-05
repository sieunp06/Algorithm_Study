import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        init();
        System.out.println(dp());
    }

    static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        dp = new int[Math.max(3, N + 1)];
        dp[1] = 1;
        dp[2] = 2;
    }

    static int dp() {
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }
        return dp[N];
    }
}
