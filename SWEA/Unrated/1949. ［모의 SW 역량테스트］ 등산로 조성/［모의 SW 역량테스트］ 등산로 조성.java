import java.io.*;
import java.util.*;

public class Solution {
    static int N, K;
    static int[][] mountain;
    static boolean[][] visited;

    static List<int[]> start;

    static int maxLen;

    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int tc = 1; tc <= T; tc++) {
            init();
            for (int[] point : start) {
                visited = new boolean[N][N];
                visited[point[0]][point[1]] = true;
                dfs(point[0], point[1], 1, false);
            }
            stringBuilder.append("#").append(tc).append(" ").append(maxLen).append("\n");
        }
        System.out.println(stringBuilder);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        mountain = new int[N][N];
        start = new ArrayList<>();
        int maxHeight = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                mountain[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (mountain[i][j] > maxHeight) {
                    maxHeight = mountain[i][j];
                    start.clear();
                    start.add(new int[] {i, j});
                }
                if (mountain[i][j] == maxHeight) {
                    start.add(new int[] {i, j});
                }
            }
        }

        maxLen = Integer.MIN_VALUE;
    }

    static void dfs(int r, int c,int depth, boolean isConst) {
        maxLen = Math.max(maxLen, depth);

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

           if (!isIn(nr, nc) || visited[nr][nc]) continue;

           if (mountain[nr][nc] < mountain[r][c]) {
               visited[nr][nc] = true;
               dfs(nr, nc, depth + 1, isConst);
               visited[nr][nc] = false;
           } else if (!isConst && mountain[nr][nc] - K < mountain[r][c]) {
               int original = mountain[nr][nc];
               mountain[nr][nc] = mountain[r][c] - 1;

               visited[nr][nc] = true;
               dfs(nr, nc, depth + 1, true);
               visited[nr][nc] = false;

               mountain[nr][nc] = original;
           }
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
