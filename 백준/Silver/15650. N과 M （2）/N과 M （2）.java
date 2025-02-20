import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;

    private static int[] arr;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[M];
        combination(1, 0);

        System.out.print(stringBuilder);
    }

    private static void combination(int at, int depth) {
        if (depth == M) {
            for (int num : arr) {
                stringBuilder.append(num).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            combination(i + 1, depth + 1);
        }
    }
}