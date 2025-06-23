import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int l;
    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    static class Knight {
        int x, y, dist;

        Knight(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {
            init();
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int startX = Integer.parseInt(stringTokenizer.nextToken());
            int startY = Integer.parseInt(stringTokenizer.nextToken());

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int endX = Integer.parseInt(stringTokenizer.nextToken());
            int endY = Integer.parseInt(stringTokenizer.nextToken());

            stringBuilder.append(bfs(startX, startY, endX, endY)).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        l = Integer.parseInt(bufferedReader.readLine());
        board = new int[l][l];
        visited = new boolean[l][l];
    }

    private static int bfs(int startX, int startY, int endX, int endY) {
        Queue<Knight> queue = new ArrayDeque<>();
        queue.offer(new Knight(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Knight now = queue.poll();

            if (now.x == endX && now.y == endY) {
                return now.dist;
            }

            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (isIn(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Knight(nx, ny, now.dist + 1));
                }
            }
        }

        return -1;
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < l && y >= 0 && y < l;
    }
}
