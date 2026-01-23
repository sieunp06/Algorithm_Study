import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[][] board, dist;
    private static final int INF = Integer.MAX_VALUE;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        init();
        zeroOneBFS();
        System.out.println(dist[n - 1][n - 1]);
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        board = new int[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }
    }

    private static void zeroOneBFS() {
        Deque<int[]> deque = new ArrayDeque<>();
        dist[0][0] = 0;
        deque.add(new int[] {0, 0});

        while (!deque.isEmpty()) {
            int[] now = deque.pollFirst();
            int r = now[0];
            int c = now[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (!isIn(nr, nc)) continue;

                int cost = (board[nr][nc] == 1) ? 0 : 1;
                if (dist[nr][nc] > dist[r][c] + cost) {
                    dist[nr][nc] = dist[r][c] + cost;

                    if (cost == 0) {
                        deque.addFirst(new int[] {nr, nc});
                    } else {
                        deque.addLast(new int[] {nr, nc});
                    }
                }
            }
        }
    }

    private static boolean isIn(int r, int c) {
        return r < n && c < n && r >= 0 && c >= 0;
    }
}
