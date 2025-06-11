import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int N, M;
    private static int[][] maze;
    private static boolean[][] visited;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(bfs());
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = input.charAt(j) - '0';
            }
        }
    }

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (isIn(nr, nc) && !visited[nr][nc] && maze[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    maze[nr][nc] = maze[r][c] + 1;
                    queue.add(new int[] {nr, nc});
                }
            }
        }
        return maze[N - 1][M - 1];
    }

    private static boolean isIn(int r, int c) {
        return r < N && r >= 0 && c < M && c >= 0;
    }
}
