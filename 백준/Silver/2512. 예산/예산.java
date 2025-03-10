import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] requests;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(search());
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        requests = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N ;i++) {
            requests[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        M = Integer.parseInt(bufferedReader.readLine());

        Arrays.sort(requests);
    }

    private static int search() {
        int left = 0; int right = requests[N - 1];
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (totalBudget(mid) > M) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }
        return result;
    }

    private static int totalBudget(int standard) {
        int total = 0;
        for (int num : requests) {
            total += Math.min(num, standard);
        }
        return total;
    }
}