import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] numbers;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException{
        init();
        combination(1, 0);
        System.out.print(stringBuilder);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        numbers = new int[M];
    }

    static void combination(int start, int depth) {
        if (depth == M) {
            printResult();
            return;
        }

        for (int i = start; i <= N; i++) {
            numbers[depth] = i;
            combination(i, depth + 1);
        }
    }

    static void printResult() {
        for (int num : numbers) {
            stringBuilder.append(num).append(" ");
        }
        stringBuilder.append("\n");
    }
}
