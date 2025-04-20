import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] children;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            int answer = getMinMoveCount();
            stringBuilder.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        System.out.print(stringBuilder);
    }

    static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        children = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            children[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    static int getMinMoveCount() {
        int[] dp = new int[N + 2];
        int maxLen = 1;

        for (int i = 0; i < N; i++) {
            dp[children[i]] = dp[children[i] - 1] + 1;
            maxLen = Math.max(maxLen, dp[children[i]]);
        }

        return N - maxLen;
    }
}
