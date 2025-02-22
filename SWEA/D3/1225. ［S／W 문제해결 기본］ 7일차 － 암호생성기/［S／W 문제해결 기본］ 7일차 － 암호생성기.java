import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    private static final int T = 10;
    private static Queue<Integer> numbers;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < T; i++) {
            String testCase = bufferedReader.readLine();
            init();
            count();
            stringBuilder.append("#").append(testCase).append(" ");
            for (int num : numbers) {
                stringBuilder.append(num).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static void init() throws IOException {
        numbers = new ArrayDeque<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int j = 0; j < 8; j++) {
            numbers.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
    }

    private static void count() {
        int idx = 1;
        while (true) {
            int current = numbers.poll() - idx;

            if (current <= 0) {
                numbers.add(0);
                break;
            }
            numbers.offer(current);
            idx = idx % 5 + 1;
        }
    }
}
