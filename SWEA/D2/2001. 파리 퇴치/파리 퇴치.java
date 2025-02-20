import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int T;
    private static int N;
    private static int M;
    private static int[][] board;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            stringBuilder.append("#").append(testCase).append(" ").append(count()).append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    private static int count() {
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < N - M + 1; i++) {
            for (int j = 0; j < N - M + 1; j++) {
                int sum = 0;
                for (int a = 0; a < M; a++) {
                    for (int b = 0; b < M; b++) {
                        sum += board[i + a][j + b];
                    }
                }

                result = Math.max(result, sum);
            }
        }

        return result;
    }
}
