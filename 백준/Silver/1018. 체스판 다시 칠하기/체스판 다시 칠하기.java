import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N, M;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(getMinPaintCount());
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            char[] input = bufferedReader.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = input[j];
            }
        }
    }

    private static int getMinPaintCount() {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min, countPaint(i, j));
            }
        }
        return min;
    }

    private static int countPaint(int startX, int startY) {
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char current = board[startX + i][startY + j];
                if (((i + j) % 2 == 0 && current != 'W') || ((i + j) % 2 == 1 && current != 'B')) {
                    count1++;
                }
                if (((i + j) % 2 == 0 && current != 'B') || ((i + j) % 2 == 1 && current != 'W')) {
                    count2++;
                }
            }
        }
        return Math.min(count1, count2);
    }
}
