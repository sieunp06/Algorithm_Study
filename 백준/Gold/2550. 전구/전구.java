import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int N;
    private static int[] indexA, dp;
    private static int[] lineB;
    private static Map<Integer, Integer> aIndexMap;

    public static void main(String[] args) throws IOException {
        init();
        find();
        System.out.print(stringBuilder);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());

        aIndexMap = new HashMap<>();
        indexA = new int[N];
        lineB = new int[N];
        dp = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            aIndexMap.put(num, i);
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            lineB[i] = num;
            indexA[i] = aIndexMap.get(num);
        }
    }

    private static void find() {
        int maxLen = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (indexA[j] < indexA[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }


        List<Integer> result = new ArrayList<>();
        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == maxLen) {
                result.add(lineB[i]);
                maxLen--;
            }
        }

        stringBuilder.append(result.size()).append("\n");
        Collections.sort(result);
        for (int num : result) {
            stringBuilder.append(num).append(" ");
        }
    }
}
