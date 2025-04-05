import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] board;
    static List<Core> cores;

    static int maxConnected, minWireLength;

    static class Core {
        int r, c;
        Core(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            dfs(0, 0, 0);
            stringBuilder.append("#").append(testCase).append(" ").append(minWireLength).append("\n");
        }
        System.out.println(stringBuilder);
    }

    static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        board = new int[N][N];
        cores = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (board[i][j] == 1 && !isEdge(i, j)) {
                    cores.add(new Core(i, j));
                }
            }
        }

        maxConnected = 0;
        minWireLength = Integer.MAX_VALUE;
    }

    static void dfs(int index, int connected, int total) {
        if (index == cores.size()) {
            if (connected > maxConnected) {
                maxConnected = connected;
                minWireLength = total;
            }
            if (connected == maxConnected) {
                minWireLength =  Math.min(minWireLength, total);
            }
            return;
        }

        Core core = cores.get(index);
        int x = core.r;
        int y = core.c;

        for (int dir = 0; dir < 4; dir++) {
            int len = canLayWire(x, y, dir);
            if (len != -1) {
                setWire(x, y, dir, 2);
                dfs(index + 1, connected + 1, total + len);
                setWire(x, y, dir, 0);
            }
        }

        dfs(index + 1, connected, total);
    }

    static int canLayWire(int r, int c, int dir) {
        int nr = r + dr[dir];
        int nc = c + dc[dir];
        int len = 0;

        while (isIn(nr, nc)) {
            if (board[nr][nc] != 0) return -1;
            nr += dr[dir];
            nc += dc[dir];
            len++;
        }

        return len;
    }

    static void setWire(int r, int c, int dir, int value) {
        int nx = r + dr[dir];
        int ny = c + dc[dir];

        while (isIn(nx, ny)) {
            board[nx][ny] = value;
            nx += dr[dir];
            ny += dc[dir];
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static boolean isEdge(int x, int y) {
        return x == 0 || x == N - 1 || y == 0 || y == N - 1;
    }
}
