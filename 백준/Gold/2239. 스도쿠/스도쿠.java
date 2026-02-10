import java.io.*;
import java.util.*;

public class Main {
    private static int[][] board;

    public static void main(String[] args) throws Exception {
        init();
        dfs();
        makePrint();
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
    }

    private static boolean dfs() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (isValid(i, j, k)) {
                            board[i][j] = k;

                            if (dfs()) return true;

                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int r, int c, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == num) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][c] == num) return false;
        }

        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    private static void makePrint() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                stringBuilder.append(board[i][j]);
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}
