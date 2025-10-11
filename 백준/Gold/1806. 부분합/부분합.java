import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N, S;
    static int[] numbers;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        process();
        System.out.print(answer != Integer.MAX_VALUE ? answer : 0);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        S = Integer.parseInt(stringTokenizer.nextToken());

        numbers = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void process() {
        int start = 0; int end = 0;
        int total = numbers[0];

        while (end < N) {
            if (total >= S) {
                answer = Math.min(answer, end - start + 1);
                total -= numbers[start];
                start++;
            } else {
                end++;
                if (end == N) break;
                total += numbers[end];
            }
        }
    }
}
