import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int K, N;
    private static long[] cables;
    private static long max = Long.MIN_VALUE;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(search());
    }

    private static void init() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        K = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());

        cables = new long[K];
        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(bufferedReader.readLine());
            max = Math.max(max, cables[i]);
        }
    }

    private static long search() {
        long left = 1; long right = max;
        long result = 0;

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

    private static boolean count(long cutLength) {
        long count = 0;
        for (long cable : cables) {
            count += cable / cutLength;
        }
        return count >= N;
    }
}