import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] icebergs;
    static boolean[][] iceberg_copy;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        icebergs = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                icebergs[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int time = 0;
        while (true) {
            int count = countPiece();
            if (count >= 2) {
                System.out.println(time);
                return;
            }
            if (count == 0) {
                System.out.println(0);
                return;
            }
            melt();
            time++;
        }
    }

    static void melt() {
        int[][] tmp_iceberg = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (icebergs[i][j] > 0) {
                    int water = 0;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if (isIn(nr, nc) && icebergs[nr][nc] == 0) {
                            water++;
                        }
                    }
                    tmp_iceberg[i][j] = Math.max(0, icebergs[i][j] - water);
                }
            }
        }
        icebergs = tmp_iceberg;
    }

    static int countPiece() {
        iceberg_copy = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (icebergs[i][j] != 0 && !iceberg_copy[i][j]) {
                    count++;
                    check(i, j);
                }
            }
        }
        return count;
    }

    static void check(int r, int c) {
        iceberg_copy[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (isIn(nr, nc) && !iceberg_copy[nr][nc] && icebergs[nr][nc] > 0) {
                check(nr, nc);
            }
        }
    }

    static boolean isIn(int r, int c) {
        return r < N && c < M && r >= 0 && c >= 0;
    }
}