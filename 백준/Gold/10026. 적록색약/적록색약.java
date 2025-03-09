import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static char[][] board;
    private static boolean[][] visited;

    private static int answerArea = 0;
    private static int answerColorWeakness = 0;

    // 상하좌우
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    answerArea++;
                    visited[i][j] = true;
                    findArea(i, j);
                }
            }
        }
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    answerColorWeakness++;
                    visited[i][j] = true;
                    findColorWeaknessArea(i, j);
                }
            }
        }

        System.out.println(answerArea + " " + answerColorWeakness);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j);
            }
        }
    }

    private static void findArea(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isIn(nr, nc) && !visited[nr][nc] && board[r][c] == board[nr][nc]) {
                visited[nr][nc] = true;
                findArea(nr, nc);
            }
        }
    }

    private static void findColorWeaknessArea(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isIn(nr, nc) && !visited[nr][nc] && isSameColor(board[r][c], board[nr][nc])) {
                visited[nr][nc] = true;
                findColorWeaknessArea(nr, nc);
            }
        }
    }

    private static boolean isSameColor(char color1, char color2) {
        if (color1 == color2) {
            return true;
        }
        if (color1 == 'G' && color2 == 'R') {
            return true;
        }
        if (color1 == 'R' && color2 == 'G') {
            return true;
        }
        return false;
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
