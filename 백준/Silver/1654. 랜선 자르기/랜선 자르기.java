import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int K, N;
    private static long max;
    private static int[] lines;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(find());
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        K = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());

        lines = new int[K];
        max = Long.MIN_VALUE;
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(bufferedReader.readLine());
            max = Math.max(lines[i], max);
        }

        Arrays.sort(lines);
    }

    private static long find() {
        long left = 1; long right = max;
        long result = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (count(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static boolean count(long cableLength) {
        long count = 0;
        for (int line : lines) {
            count += line / cableLength;
        }
        return count >= N;
    }
}
