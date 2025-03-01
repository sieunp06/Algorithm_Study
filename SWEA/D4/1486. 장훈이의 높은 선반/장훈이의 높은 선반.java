import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    private static int T;
    private static int N, B;
    private static int[] heights;
    private static int answer;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            stringBuilder.append("#").append(testCase).append(" ").append(pick() - B).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        B = Integer.parseInt(stringTokenizer.nextToken());

        heights = new int[N];
        answer = Integer.MAX_VALUE;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static int pick() {
        int minDiff = Integer.MAX_VALUE;
        int mask = 1 << N;

        for (int i = 0; i < mask; i++) {
            int total = 0;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    total += heights[j];
                }
            }

            if (total >= B) {
                minDiff = Math.min(minDiff, total);
            }
        }
        return minDiff;
    }
}