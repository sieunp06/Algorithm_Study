import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        boolean[] visited = new boolean[N + 1];
        int[] arr = new int[M];
        combination(visited, arr, 0, N, M);

        System.out.println(stringBuilder);
    }

    private static void combination(boolean[] visited, int[] arr, int depth, int N, int M) {
        if (depth == M) {
            for (int num : arr) {
                stringBuilder.append(num).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            arr[depth] = i;
            combination(visited, arr, depth + 1, N, M);
            visited[i] = false;
        }
    }
}