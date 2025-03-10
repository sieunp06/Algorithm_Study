import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] numbers;
    private static int[] target;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        for (int num : target) {
            System.out.println(search(num) ? 1 : 0);
        }
    }

    private static void init() throws IOException {
       N = Integer.parseInt(bufferedReader.readLine());
       numbers = new int[N];

       stringTokenizer = new StringTokenizer(bufferedReader.readLine());
       for (int i = 0; i < N; i++) {
           numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
       }
        Arrays.sort(numbers);

       M = Integer.parseInt(bufferedReader.readLine());
       target = new int[M];

       stringTokenizer = new StringTokenizer(bufferedReader.readLine());
       for (int i = 0; i < M; i++) {
           target[i] = Integer.parseInt(stringTokenizer.nextToken());
       }
    }

    private static boolean search(int num) {
        int left = 0; int right = N - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (numbers[mid] == num) {
                return true;
            }
            if (numbers[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}