import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int N;
    private static int white, blue;
    private static int[][] paper;

    public static void main(String[] args) throws IOException {
        init();
        dfs(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        paper = new int[N][N];
        white = 0;
        blue = 0;

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    private static void dfs(int r, int c, int size) {
        if (checkSameColor(r, c, size)) {
            count(paper[r][c]);
            return;
        }

        int newSize = size / 2;
        dfs(r, c, newSize);
        dfs(r + newSize, c, newSize);
        dfs(r, c + newSize, newSize);
        dfs(r + newSize, c + newSize, newSize);
    }

    private static boolean checkSameColor(int r, int c, int size) {
        int color = paper[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void count(int color) {
        if (color == 1) {
            blue++;
            return;
        }
        white++;
    }
}
