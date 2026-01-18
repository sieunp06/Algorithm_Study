import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[][] board;
    static int answer = 0;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        board = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int mask = 1 << (board[0][0] - 'A');
        dfs(0, 0, mask, 1);

        System.out.println(answer);
    }

    private static void dfs(int r, int c, int mask, int depth) {
        answer = Math.max(answer, depth);

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (!isIn(nr, nc)) continue;

            int next = board[nr][nc] - 'A';
            if ((mask & (1 << next)) == 0) {
                dfs(nr, nc, mask | (1 << next), depth + 1);
            }
        }
    }

    private static boolean isIn(int r, int c) {
        return r < R && c < C && r >= 0 && c >= 0;
    }
}