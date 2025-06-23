import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int N, M;
    private static int[][] board;
    private static boolean[][][] visited;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static class Node {
        int r, c, dist, broken;

        Node(int r, int c, int dist, int broken) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.broken = broken;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(bfs());
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }
    }

    private static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int r = now.r;
            int c = now.c;

            if (r == N - 1 && c == M - 1) {
                return now.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (!isIn(nr, nc)) continue;

                // 벽이 아닐 때
                if (board[nr][nc] == 0 && !visited[nr][nc][now.broken]) {
                    visited[nr][nc][now.broken] = true;
                    queue.add(new Node(nr, nc, now.dist + 1, now.broken));
                }

                // 벽인데 아직 부순 적 없을 때
                if (board[nr][nc] == 1 && now.broken == 0 && !visited[nr][nc][1]) {
                    visited[nr][nc][1] = true;
                    queue.add(new Node(nr, nc, now.dist + 1, 1));
                }
            }
        }
        return -1;
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
