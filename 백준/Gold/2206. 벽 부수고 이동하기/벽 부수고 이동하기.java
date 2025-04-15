import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;

    static class Node {
        int r, c, distance;
        boolean broken;

        Node(int r, int c, int distance, boolean broken) {
            this.r = r;
            this.c = c;
            this.distance = distance;
            this.broken = broken;
        }
    }

    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(bfs());
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
    }

    static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 1, false));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.r == N - 1 && now.c == M - 1) return now.distance;

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (!isIn(nr, nc)) continue;

                if (map[nr][nc] == 1) {
                    if (!now.broken && !visited[nr][nc][1]) {
                        visited[nr][nc][1] = true;
                        queue.add(new Node(nr, nc, now.distance + 1, true));
                    }
                } else {
                    int brokenIdx = now.broken ? 1 : 0;
                    if (!visited[nr][nc][brokenIdx]) {
                        visited[nr][nc][brokenIdx] = true;
                        queue.add(new Node(nr, nc, now.distance + 1, now.broken));
                    }
                }
            }
        }
        return -1;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
