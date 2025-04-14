import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] box;

    static Queue<int[]> tomatoes;

    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        int answer = bfs();
        System.out.println(isAllRipe() ? answer : -1);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());

        box = new int[N][M];
        tomatoes = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (box[i][j] == 1) {
                    tomatoes.add(new int[] {i, j, 0});
                }
            }
        }
    }

    static int bfs() {
        int day = 0;
        while (!tomatoes.isEmpty()) {
            int[] now = tomatoes.poll();
            day = Math.max(day, now[2]);

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (isIn(nr, nc) && box[nr][nc] == 0) {
                    box[nr][nc] = 1;
                    tomatoes.add(new int[] {nr, nc, now[2] + 1});
                }
            }
        }
        return day;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    static boolean isAllRipe() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
