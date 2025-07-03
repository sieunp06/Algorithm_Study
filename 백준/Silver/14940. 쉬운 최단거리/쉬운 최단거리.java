import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int n, m;
    static int[][] map;
    static int[][] distance;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        printResult();
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (map[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    distance[nr][nc] = distance[r][c] + 1;
                }
            }
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    static void printResult() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    stringBuilder.append(0).append(" ");
                } else if (!visited[i][j]) {
                    stringBuilder.append(-1).append(" ");
                } else {
                    stringBuilder.append(distance[i][j]).append(" ");
                }
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
    }
}
