import java.io.*;
import java.util.*;

public class Main {
    private static int R, C;
    private static int[][] cheese;
    private static boolean[][] isWall;
    private static boolean[][] clonedWall;

    private static int countOneTimeAgo = 0;
    private static int time = 0;

    // 상 하 좌 우
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        findWall(0, 0);

        do {
            time++;
            countOneTimeAgo = count();
            melt();
        } while (count() > 0);
        System.out.println(time);
        System.out.println(countOneTimeAgo);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        cheese = new int[R][C];
        isWall = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < C; j++) {
                cheese[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }
    
    private static void findWall(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (isIn(nr, nc) && !isWall[nr][nc] && cheese[nr][nc] == 0) {
                isWall[nr][nc] = true;
                findWall(nr, nc);
            }
        }
    }

    private static void melt() {
        clonedWall = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                clonedWall[i][j] = isWall[i][j];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (cheese[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if (isIn(nr, nc) && clonedWall[nr][nc]) {
                            isWall[i][j] = true;
                            cheese[i][j] = 0;
                            findWall(i, j);
                            break;
                        }
                    }
                }
            }
        }
    }

    private static int count() {
        int count = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (cheese[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}
