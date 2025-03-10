import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static long[] solutions;

    private static int left, right;
    private static long min;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        search();
        System.out.println(solutions[left] + " " + solutions[right]);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        solutions = new long[N];

        min = Long.MAX_VALUE;

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Long.parseLong(stringTokenizer.nextToken());
        }
    }

    private static void search() {
        int lt = 0; int rt = N - 1;

        while (lt < rt) {
            long sum = solutions[lt] + solutions[rt];
            if (Math.abs(min) > Math.abs(sum)) {
                left = lt; right = rt;
                min = sum;
            }
            if (sum < 0) {
                lt++;
            } else {
                rt--;
            }
        }
    }
}