import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] board = new int[N][3];
        int[][] dp_max = new int[N][3];
        int[][] dp_min = new int[N][3];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        dp_max[0][0] = board[0][0]; dp_max[0][1] = board[0][1]; dp_max[0][2] = board[0][2];
        dp_min[0][0] = board[0][0]; dp_min[0][1] = board[0][1]; dp_min[0][2] = board[0][2];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp_max[i][j] = Math.max(dp_max[i - 1][j], dp_max[i - 1][j + 1]) + board[i][j];
                    dp_min[i][j] = Math.min(dp_min[i - 1][j], dp_min[i - 1][j + 1]) + board[i][j];
                } else if (j == 2) {
                    dp_max[i][j] = Math.max(dp_max[i - 1][j], dp_max[i - 1][j - 1]) + board[i][j];
                    dp_min[i][j] = Math.min(dp_min[i - 1][j], dp_min[i - 1][j - 1]) + board[i][j];
                } else {
                    dp_max[i][j] = Math.max(Math.max(dp_max[i - 1][0], dp_max[i - 1][1]), dp_max[i - 1][2]) + board[i][j];
                    dp_min[i][j] = Math.min(Math.min(dp_min[i - 1][0], dp_min[i - 1][1]), dp_min[i - 1][2]) + board[i][j];
                }
            }
        }

        int max = Integer.MIN_VALUE; int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, dp_max[N - 1][i]);
            min = Math.min(min, dp_min[N - 1][i]);
        }

        System.out.println(max + " " + min);
    }
}
