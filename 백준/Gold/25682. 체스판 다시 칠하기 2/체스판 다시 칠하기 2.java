import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        int[][] prefixW = new int[N + 1][M + 1];
        int[][] prefixB = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                char current = board[i - 1][j - 1];
                boolean even = ((i + j) % 2 == 0);

                char expectedB = even ? 'B' : 'W';
                char expectedW = even ? 'W' : 'B';

                int diffB = (current == expectedB) ? 0 : 1;
                int diffW = (current == expectedW) ? 0 : 1;

                prefixB[i][j] = prefixB[i - 1][j] + prefixB[i][j - 1] - prefixB[i - 1][j - 1] + diffB;
                prefixW[i][j] = prefixW[i - 1][j] + prefixW[i][j - 1] - prefixW[i - 1][j - 1] + diffW;
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int x1 = i - K + 1;
                int y1 = j - K + 1;

                int repaintB = getSum(prefixB, x1, y1, i, j);
                int repaintW = getSum(prefixW, x1, y1, i, j);

                answer = Math.min(answer, Math.min(repaintB, repaintW));
            }
        }

        System.out.println(answer);
    }

    private static int getSum(int[][] p, int x1, int y1, int x2, int y2) {
        return p[x2][y2] - p[x1 - 1][y2] - p[x2][y1 - 1] + p[x1 - 1][y1 - 1];
    }
}
