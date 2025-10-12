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
    static long[] numbers;
    static long[] answer;

    public static void main(String[] args) throws IOException {
        init();
        find();
        makeAnswer();
        System.out.print(stringBuilder);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        numbers = new long[N];
        answer = new long[3];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Long.parseLong(stringTokenizer.nextToken());
        }
        Arrays.sort(numbers);
    }

    private static void find() {
        long total = Long.MAX_VALUE;

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = numbers[i] + numbers[left] + numbers[right];
                long abs = Math.abs(sum);
                if (abs < total) {
                    total = abs;
                    answer[0] = numbers[i];
                    answer[1] = numbers[left];
                    answer[2] = numbers[right];

                    if (abs == 0) {
                        return;
                    }
                }

                if (sum > 0) right--;
                else left++;
            }
        }
    }

    private static void makeAnswer() {
        stringBuilder.append(answer[0]).append(" ").append(answer[1]).append(" ").append(answer[2]);
    }
}
