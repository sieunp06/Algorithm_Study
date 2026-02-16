import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;
    private static int N, K, W;
    private static int[] times, dp;
    private static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            init();
            stringBuilder.append(dp(W)).append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        times = new int[N + 1];
        dp = new int[N + 1];
        Arrays.fill(dp, -1);

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= N; i++) {
            times[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int X = Integer.parseInt(stringTokenizer.nextToken());
            int Y = Integer.parseInt(stringTokenizer.nextToken());

            list[Y].add(X);
        }

        W = Integer.parseInt(bufferedReader.readLine());
    }

    private static int dp(int target) {
        if (dp[target] != -1) return dp[target];

        int best = 0;
        for (int num : list[target]) {
            best = Math.max(best, dp(num));
        }
        dp[target] = best + times[target];
        return dp[target];
    }
}
