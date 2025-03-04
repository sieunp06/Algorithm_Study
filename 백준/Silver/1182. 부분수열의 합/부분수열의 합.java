import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, S;
    private static int[] numbers;

    private static int answer;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        find(0, 0, 0);
        System.out.println(answer);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        S = Integer.parseInt(stringTokenizer.nextToken());

        numbers = new int[N];
        answer = 0;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void find(int idx, int count, int total) {
        if (idx == N) {
            if (total == S && count != 0) {
                answer++;
            }
            return;
        }

        find(idx + 1, count + 1, total + numbers[idx]);
        find(idx + 1, count, total);

    }
}