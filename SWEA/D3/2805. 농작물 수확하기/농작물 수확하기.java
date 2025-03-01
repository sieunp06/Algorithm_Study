import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    private static int T;
    private static int N;
    private static int[][] farm;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            stringBuilder.append("#").append(testCase).append(" ").append(calculate()).append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        farm = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                farm[i][j] = input.charAt(j) - '0';
            }
        }
    }

    private static int calculate() {
        int N = farm.length;
        int M = farm[0].length;
        int midRow = N / 2;
        int midCol = M / 2;
        int score = 0;

        for (int i = 0; i <= midRow; i++) {
            int startCol = midCol - i;
            int endCol = midCol + i;
            for (int j = startCol; j <= endCol; j++) {
                score += farm[i][j];
            }
        }

        for (int i = midRow + 1; i < N; i++) {
            int startCol = i - midRow;
            int endCol = M - 1 - (i - midRow);
            for (int j = startCol; j <= endCol; j++) {
                score += farm[i][j];
            }
        }

        return score;
    }
}