import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N, C;
    static int max;
    static int[] homes;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(find());
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        homes = new int[N];
        max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(bufferedReader.readLine());
            max = Math.max(homes[i], max);
        }

        Arrays.sort(homes);
    }

    private static int find() {
        int left = 0; int right = max;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static boolean check(int mid) {
        int total = 1;
        int installed = homes[0];
        for (int i = 1; i < homes.length; i++) {
            if (homes[i] - installed >= mid) {
                total++;
                installed = homes[i];
            }
        }
        return total >= C;
    }
}
