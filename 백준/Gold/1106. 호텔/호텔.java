import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int C = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        int[] cost = new int[N];
        int[] people = new int[N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            cost[i] = Integer.parseInt(stringTokenizer.nextToken());
            people[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int maxSize = C + 100;
        int[] dp = new int[maxSize];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = people[i]; j < maxSize; j++) {
                dp[j] = Math.min(dp[j], dp[j - people[i]] + cost[i]);
            }
        }

        int answer = INF;
        for (int i = C; i < maxSize; i++) {
            answer = Math.min(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
