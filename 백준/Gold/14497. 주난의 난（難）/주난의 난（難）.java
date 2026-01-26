import java.io.*;
import java.util.*;

public class Main {

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int sr, sc, tr, tc;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        init();
        bfs();
        System.out.println(visited[tr][tc]);
    }

    private static void init() throws Exception {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        sr = Integer.parseInt(stringTokenizer.nextToken()) - 1;
        sc = Integer.parseInt(stringTokenizer.nextToken()) - 1;
        tr = Integer.parseInt(stringTokenizer.nextToken()) - 1;
        tc = Integer.parseInt(stringTokenizer.nextToken()) - 1;

        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = (line.charAt(j) == '0') ? 0 : 1;
            }
        }
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        visited[sr][sc] = 1;

        int wave = 0;

        while (map[tr][tc] == 1) {
            wave++;
            Queue<int[]> nextQ = new ArrayDeque<>();

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (!isIn(nr, nc)) continue;
                    if (visited[nr][nc] != 0) continue;

                    visited[nr][nc] = wave;

                    if (map[nr][nc] == 0) {
                        q.offer(new int[]{nr, nc});
                    } else {
                        map[nr][nc] = 0;
                        nextQ.offer(new int[]{nr, nc});
                    }
                }
            }
            q = nextQ;
        }
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
