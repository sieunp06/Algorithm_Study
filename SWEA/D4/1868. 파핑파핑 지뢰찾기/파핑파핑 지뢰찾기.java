import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static int T, N;
    private static char[][] board;
    private static boolean[][] visited;

    private static int count;

    // 상하좌우, 좌상, 좌하, 우상, 우하
    private static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};
    private static int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            findNotBomb();
            findLeftBomb();
            stringBuilder.append("#").append(testCase).append(" ").append(count).append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static void findLeftBomb() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isBomb(i, j) && !visited[i][j]) {
                    visited[i][j] = true;
                    count++;
                }
            }
        }
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        board = new char[N][N];
        visited = new boolean[N][N];

        count = 0;

        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j);  // *: 지뢰, .: 지뢰 없음, c: 클릭한 지뢰 없는 칸
            }
        }
    }

    private static void findNotBomb() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '.' && !visited[i][j]) {
                    if (isBombNearBy(i, j)) {
                        count++;
                        find(i, j);
                    }
                }
            }
        }
    }

    private static void find(int r, int c) {
        visited[r][c] = true;
        if (isBombNearBy(r, c)) {
            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (isIn(nr, nc) && !visited[nr][nc]) {
                    find(nr, nc);
                }
            }
        }
    }

    private static boolean isBombNearBy(int r, int c) {
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (!isIn(nr, nc)) {
                continue;
            }
            if (isBomb(nr, nc)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    private static boolean isBomb(int r, int c) {
        return board[r][c] == '*';
    }
}
