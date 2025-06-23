import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    private static int M, N, H;
    private static int[][][] box;
    private static Queue<Tomato> tomatoes;

    private static int result = 0;

    private static class Tomato {
        int r, c, z, day;

        Tomato(int r, int c, int z, int day) {
            this.r = r;
            this.c = c;
            this.z = z;
            this.day = day;
        }
    }

    private static int[] dr = {0, 0, -1, 1, 0, 0};
    private static int[] dc = {0, 0, 0, 0, -1, 1};
    private static int[] dz = {-1, 1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        init();
        countDays();
        System.out.println(isAllRipe() ? result : -1);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        H = Integer.parseInt(stringTokenizer.nextToken());

        box = new int[H][N][M];
        tomatoes = new ArrayDeque<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(stringTokenizer.nextToken());
                    if (box[i][j][k] == 1) {
                        tomatoes.add(new Tomato(j, k, i, 0));
                    }
                }
            }
        }
    }

    private static int countDays() {
        while (!tomatoes.isEmpty()) {
            Tomato now = tomatoes.poll();
            int now_r = now.r;
            int now_c = now.c;
            int now_z = now.z;
            int day = now.day;

            for (int i = 0; i < 6; i++) {
                int nr = now_r + dr[i];
                int nc = now_c + dc[i];
                int nz = now_z + dz[i];

                if (isIn(nr, nc, nz) && box[nz][nr][nc] == 0) {
                    box[nz][nr][nc] = 1;
                    tomatoes.add(new Tomato(nr, nc, nz, day + 1));
                    result = Math.max(result, day + 1);
                }
            }
        }
        return result;
    }

    private static boolean isIn(int r, int c, int z) {
        return r >= 0 && r < N && c >= 0 && c < M && z >= 0 && z < H;
    }

    private static boolean isAllRipe() {
        for (int z = 0; z < H; z++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (box[z][r][c] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}