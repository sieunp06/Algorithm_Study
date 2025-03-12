import java.io.*;
import java.util.*;

public class Main {
    private static int T, N, M;
    private static long[] numbersA, numbersB;

    private static Map<Long, Long> mapA, mapB;

    private static long answer = 0;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        makeSumList();
        sum();
        System.out.println(answer);
    }

    private static void init() throws IOException {
        T = Integer.parseInt(bufferedReader.readLine());
        N = Integer.parseInt(bufferedReader.readLine());
        numbersA = new long[N + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= N; i++) {
            numbersA[i] = Integer.parseInt(stringTokenizer.nextToken()) + numbersA[i - 1];
        }

        M = Integer.parseInt(bufferedReader.readLine());
        numbersB = new long[M + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= M; i++) {
            numbersB[i] = Integer.parseInt(stringTokenizer.nextToken()) + numbersB[i - 1];
        }

        mapA = new HashMap<>();
        mapB = new HashMap<>();
    }

    private static void makeSumList() {
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                long sum = numbersA[j + 1] - numbersA[i];
                mapA.put(sum, mapA.getOrDefault(sum, 0L) + 1);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = i; j < M; j++) {
                long sum = numbersB[j + 1] - numbersB[i];
                mapB.put(sum, mapB.getOrDefault(sum, 0L) + 1);
            }
        }
    }

    private static void sum() {
        for (long num : mapA.keySet()) {
            long target = T - num;
            if (mapB.containsKey(target)) {
                answer += mapA.get(num) * mapB.get(target);
            }
        }
    }
}
