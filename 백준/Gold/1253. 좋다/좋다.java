import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        init();
        System.out.print(process());
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        numbers = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(numbers);
    }

    private static int process() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (isGood(i)) count++;
        }

        return count;
    }

    private static boolean isGood(int target) {
        int start = 0; int end = N - 1;

        while (start < end) {
            if (start == target) { start++; continue; }
            if (end == target) { end--; continue; }

            int total = numbers[start] + numbers[end];
            if (total == numbers[target]) {
                return true;
            } else if (total < numbers[target]) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }
}
