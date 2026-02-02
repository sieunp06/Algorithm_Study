import java.io.*;
import java.util.*;

public class Main {
    private static int R, C, T;
    private static int[][] board;
    private static int[] machine;

    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        init();
        while (T-- > 0) {
            spread();
            circulate_forward();
            circulate_backward();
        }
        System.out.println(sumDust());
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        T = Integer.parseInt(stringTokenizer.nextToken());

        board = new int[R][C];
        machine = new int[2];
        Arrays.fill(machine, -1);

        for (int i = 0; i < R; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (board[i][j] == -1 && machine[0] == -1) {
                    machine[0] = i;
                    machine[1] = i + 1;
                }
            }
        }
    }

    private static void spread() {
        int[][] spread = new int[R][C];

        spread[machine[0]][0] = -1;
        spread[machine[1]][0] = -1;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] > 0) {
                    int target = board[i][j] / 5;
                    int dirCount = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if (isIn(nr, nc) && board[nr][nc] != -1) {
                            spread[nr][nc] += target;
                            dirCount++;
                        }
                    }
                    spread[i][j] += board[i][j] - target * dirCount;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            System.arraycopy(spread[i], 0, board[i], 0, C);
        }
    }

    private static void circulate_forward() {
        int r = machine[0];

        for (int i = r - 1; i > 0; i--)
            board[i][0] = board[i - 1][0];

        for (int i = 0; i < C - 1; i++)
            board[0][i] = board[0][i + 1];

        for (int i = 0; i < r; i++)
            board[i][C - 1] = board[i + 1][C - 1];

        for (int i = C - 1; i > 1; i--)
            board[r][i] = board[r][i - 1];

        board[r][1] = 0;
    }

    private static void circulate_backward() {
        int r = machine[1];

        for (int i = r + 1; i < R - 1; i++)
            board[i][0] = board[i + 1][0];

        for (int i = 0; i < C - 1; i++)
            board[R - 1][i] = board[R - 1][i + 1];

        for (int i = R - 1; i > r; i--)
            board[i][C - 1] = board[i - 1][C - 1];

        for (int i = C - 1; i > 1; i--)
            board[r][i] = board[r][i - 1];

        board[r][1] = 0;
    }

    private static int sumDust() {
        int sum = 0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (board[i][j] > 0) sum += board[i][j];
        return sum;
    }

    private static boolean isIn(int r, int c) {
        return r < R && c < C && r >= 0 && c >= 0;
    }
}
