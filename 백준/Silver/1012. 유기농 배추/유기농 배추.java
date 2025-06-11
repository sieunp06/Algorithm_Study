import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int M, N, K, count;
    private static int[][] field;
    private static boolean[][] visited;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            findCabbage();
            stringBuilder.append(count).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken());  // 배추밭의 가로길이
        N = Integer.parseInt(stringTokenizer.nextToken());  // 배추밭의 세로길이
        K = Integer.parseInt(stringTokenizer.nextToken());  // 배추가 심어져 있는 위치의 개수

        field = new int[N][M];
        visited = new boolean[N][M];
        count = 0;

        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int X = Integer.parseInt(stringTokenizer.nextToken());
            int Y = Integer.parseInt(stringTokenizer.nextToken());

            field[Y][X] = 1;
        }
    }

    private static void findCabbage() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isIn(nr, nc) && field[nr][nc] == 1 && !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }

    private static boolean isIn(int r, int c) {
        return r < N && r >= 0 && c < M && c >= 0;
    }
}
