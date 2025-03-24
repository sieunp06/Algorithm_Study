import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    private static int[] numbers;
    private static int[] types;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        backtracking(1, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        numbers = new int[N];
        types = new int[4];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < types.length; i++) {
            types[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void backtracking(int depth, int total) {
        if (depth == N) {
            max = Math.max(max, total);
            min = Math.min(min, total);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (types[i] > 0) {
                types[i]--;

                switch (i) {
                    case 0: backtracking(depth + 1, total + numbers[depth]); break;
                    case 1: backtracking(depth + 1, total - numbers[depth]); break;
                    case 2: backtracking(depth + 1, total * numbers[depth]); break;
                    case 3: backtracking(depth + 1, total / numbers[depth]); break;
                }
                types[i]++;
            }
        }
    }
}