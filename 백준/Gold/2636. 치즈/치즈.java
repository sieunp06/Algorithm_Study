import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] board;
    private static boolean[][] isVisited;

    private static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        init();

        int time = 0;
        int lastCount = 0;

        while (true) {
            int cheese = countCheese();
            if (cheese == 0) break;

            lastCount = cheese;
            melt();
            time++;
        }

        System.out.println(time);
        System.out.println(lastCount);
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    private static int countCheese() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void melt() {
        List<Point> meltList = new ArrayList<>();
        isVisited = new boolean[N][M];
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0));
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int r = now.r;
            int c = now.c;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (!isIn(nr, nc)) continue;
                if (isVisited[nr][nc]) continue;

                isVisited[nr][nc] = true;
                if (board[nr][nc] == 1) {
                    meltList.add(new Point(nr, nc));
                } else {
                    queue.add(new Point(nr, nc));
                }
            }
        }

        for (Point p : meltList) {
            board[p.r][p.c] = 0;
        }
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
