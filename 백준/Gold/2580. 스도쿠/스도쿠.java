import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int[][] board = new int[9][9];
    static List<Node> list = new ArrayList<>();

    static boolean isCompleted = false;

    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException{
        init();
        backtracking(0);
    }

    static void init() throws IOException {
        for (int i = 0; i < 9; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (board[i][j] == 0) {
                    list.add(new Node(i, j));
                }
            }
        }
    }

    static void backtracking(int idx) {
        if (isCompleted) {
            return;
        }

        if (idx == list.size()) {
            printResult();
            isCompleted = true;
            return;
        }

        Node now = list.get(idx);
        for (int i = 1; i <= 9; i++) {
            if (isPossible(now.r, now.c, i)) {
                board[now.r][now.c] = i;
                backtracking(idx + 1);
                board[now.r][now.c] = 0;
            }
        }
    }

    static boolean isPossible(int r, int c, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == num) {
                return false;
            }
            if (board[i][c] == num) {
                return false;
            }
        }
        int startRow = (r / 3) * 3;
        int startCol = (c / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    static void printResult() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                stringBuilder.append(board[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
    }
}
