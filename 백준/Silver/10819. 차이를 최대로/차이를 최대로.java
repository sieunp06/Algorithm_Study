import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] numbers;

    private static int answer;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        do {
            answer = Math.max(calculate(), answer);
        } while (nextPermutation());

        System.out.println(answer);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        numbers = new int[N];
        answer = 0;

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(numbers);
    }

    private static boolean nextPermutation() {
        int i = N - 1;
        while (i > 0 && numbers[i - 1] >= numbers[i]) {
            --i;
        }

        if (i <= 0) {
            return false;
        }

        int j = N - 1;
        while (j > 0 && numbers[i - 1] >= numbers[j]) {
            --j;
        }

        swap(i - 1, j);
        Arrays.sort(numbers, i, N);
        return true;
    }

    private static void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private static int calculate() {
        int total = 0;

        for (int i = 1; i < N; i++) {
            total += Math.abs(numbers[i - 1] - numbers[i]);
        }

        return total;
    }
}