import java.io.*;
import java.util.*;

public class Solution {
    static final int NUM_OF_TICKETS = 4;
    static final int MONTH = 12;

    static int[] tickets = new int[NUM_OF_TICKETS];
    static int[] months = new int[MONTH + 1];
    static int[] dp = new int[MONTH + 1];

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int tc = 1; tc <= T; tc++) {
            init();
            stringBuilder.append("#").append(tc).append(" ").append(dp()).append("\n");
        }
        System.out.println(stringBuilder);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < NUM_OF_TICKETS; i++) {
            tickets[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= MONTH; i++) {
            months[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    static int dp() {
        for (int i = 1; i <= MONTH; i++) {
            int oneDay = dp[i - 1] + tickets[0] * months[i];
            int month = dp[i - 1] + tickets[1];
            int threeMonth = dp[Math.max(0, i - 3)] + tickets[2];

            dp[i] = Math.min(oneDay, Math.min(month, threeMonth));
        }

        return Math.min(tickets[3], dp[MONTH]);
    }
}
