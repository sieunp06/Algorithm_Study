import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    private static int w, h;
    private static int[][] map;
    private static boolean[][] visited;

    private static int count;

    private static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        while (true) {
            init();
            if (w == 0 && h == 0) break;
            findLand();
            stringBuilder.append(count).append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        w = Integer.parseInt(stringTokenizer.nextToken());
        h = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[h][w];
        visited = new boolean[h][w];
        count = 0;

        for (int i = 0; i < h; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    private static void findLand() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count++;
                    countIslands(i, j);
                }
            }
        }
    }

    private static void countIslands(int r, int c) {
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
                visited[nr][nc] = true;
                countIslands(nr, nc);
            }
        }
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r < h && c >= 0 && c < w;
    }
}