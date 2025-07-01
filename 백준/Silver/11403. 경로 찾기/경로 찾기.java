import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int N;
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        init();
        floydWarshall();
        printResult();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    private static void floydWarshall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (board[j][i] == 1 && board[i][k] == 1) {
                        board[j][k] = 1;
                    }
                }
            }
        }
    }

    private static void printResult() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                stringBuilder.append(board[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
    }
}
