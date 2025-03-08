import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    private static final int TARGET = 2;

    private static int T;
    private static long N;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Long.parseLong(bufferedReader.readLine());
            stringBuilder.append("#").append(testCase).append(" ").append(game(N)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int game(long N) {
        int answer = 0;
        while (true) {
            if (N == TARGET) break;
            long num = (long) Math.sqrt(N);

            if (num * num == N) {
                N = num;
            } else {
                answer += (num + 1) * (num + 1) - N;
                N = num + 1;
            }
            answer++;
        }
        return answer;
    }
}