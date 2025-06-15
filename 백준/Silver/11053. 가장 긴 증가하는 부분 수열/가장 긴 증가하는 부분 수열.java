import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int N;
    private static int[] numbers, dp;

    public static void main(String[] args) throws IOException {
        init();
        findByDp();
        System.out.println(findMax());
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        numbers = new int[N];
        dp = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void findByDp() {
        Arrays.fill(dp, 1);
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
    }

    private static int findMax() {
        int max = dp[0];
        for (int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
