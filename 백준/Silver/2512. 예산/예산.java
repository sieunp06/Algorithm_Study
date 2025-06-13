import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N, M, max;
    static int[] regions;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(find());
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        regions = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        max = Integer.MIN_VALUE;
        for (int i = 0 ; i < N; i++) {
            regions[i] = Integer.parseInt(stringTokenizer.nextToken());
            max = Math.max(max, regions[i]);
        }
        Arrays.sort(regions);

        M = Integer.parseInt(bufferedReader.readLine());
    }

    private static int find() {
        int left = 0; int right = max;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sumTotal(mid) <= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static int sumTotal(int mid) {
        int total = 0;
        for (int region : regions) {
            total += (Math.min(region, mid));
        }
        return total;
    }
}
