import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] area;
    static boolean[][] isVisited;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static int answer = Integer.MIN_VALUE;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        for (int level = min - 1; level <= max; level++) {
            answer = Math.max(answer, find(level));
        }
        System.out.println(answer);
    }

    static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        area = new int[N][N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                max = Math.max(max, area[i][j]);
                min = Math.min(min, area[i][j]);
            }
        }
    }

    static int find(int level) {
        int count = 0;
        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (area[i][j] > level && !isVisited[i][j]) {
                    count++;
                    isVisited[i][j] = true;
                    dfs(i, j, level);
                }
            }
        }
        return count;
    }

    static void dfs(int r, int c, int level) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isIn(nr, nc) && !isVisited[nr][nc] && area[nr][nc] > level) {
                isVisited[nr][nc] = true;
                dfs(nr, nc, level);
            }
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}