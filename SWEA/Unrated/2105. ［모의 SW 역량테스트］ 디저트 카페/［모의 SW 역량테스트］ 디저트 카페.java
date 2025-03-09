import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    private static int T, N;
    private static int[][] cafe;
    private static boolean[][] visited;
    private static boolean[] eaten;
    private static int answer;

    // 우하, 좌하, 좌상, 우상
    private static int[] dr = {1, 1, -1, -1};
    private static int[] dc = {1, -1, -1, 1};

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited = new boolean[N][N];
                    eaten = new boolean[101];

                    visited[i][j] = true;
                    eaten[cafe[i][j]] = true;
                    dfs(i, j, i, j, 0, 1);
                    visited[i][j] = false;
                    eaten[cafe[i][j]] = false;
                }
            }
            stringBuilder.append("#").append(testCase).append(" ").append(answer == Integer.MIN_VALUE ? -1 : answer).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        cafe = new int[N][N];
        answer = Integer.MIN_VALUE; 

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                cafe[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    private static void dfs(int initR, int initC, int r, int c, int dir, int count) {
        for (int i = dir; i <= dir + 1 && i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr == initR && nc == initC && count >= 4) {
                answer = Math.max(answer, count);
                return;
            }

            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && !eaten[cafe[nr][nc]]) {
                visited[nr][nc] = true;
                eaten[cafe[nr][nc]] = true;

                dfs(initR, initC, nr, nc, i, count + 1);

                visited[nr][nc] = false;
                eaten[cafe[nr][nc]] = false;
            }
        }
    }
}
