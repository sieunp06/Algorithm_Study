import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, C;
    private static int[] homes;

    private static int max = Integer.MIN_VALUE;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(search());
    }

    private static void init() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        homes = new int[N];
        for (int i = 0; i < N ; i++) {
            homes[i] = Integer.parseInt(bufferedReader.readLine());
            max = Math.max(max, homes[i]);
        }
        Arrays.sort(homes);
    }

    private static long search() {
        int left = 1; int right = max;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canInstall(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static boolean canInstall(int distance) {
        int count = 1;
        int lastInstalled = homes[0];
        for (int i = 1; i < N; i++) {
            if (homes[i] - lastInstalled >= distance) {
                lastInstalled = homes[i];
                count++;
            }
        }
        return count >= C;
    }
}