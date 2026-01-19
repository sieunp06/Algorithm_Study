import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static int M, N;
    private static int[][] board;
    private static int[][] memo;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenize;

        stringTokenize = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(stringTokenize.nextToken());
        N = Integer.parseInt(stringTokenize.nextToken());
        board = new int[M][N];
        memo = new int[M][N];

        for (int i = 0; i < M; i++) {
            stringTokenize = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(stringTokenize.nextToken());
            }
            Arrays.fill(memo[i], -1);
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int r, int c) {
        if (r == M - 1 && c == N - 1) return 1;

        if (memo[r][c] != -1) {
            return memo[r][c];
        }

        memo[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isIn(nr, nc) && board[r][c] > board[nr][nc]) {
                memo[r][c] += dfs(nr, nc);
            }
        }
        return memo[r][c];
    }

    private static boolean isIn(int r, int c) {
        return r < M && c < N && r >= 0 && c >= 0;
    }
}
