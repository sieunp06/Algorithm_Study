import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    private static int T, N;
    private static int[][] rooms;
    private static int[][] memo;

    // 상하좌우
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            int maxMove = 0;
            int startRoom = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int moves = find(i, j);
                    if (moves > maxMove || (moves == maxMove && rooms[i][j] < startRoom)) {
                        maxMove = moves;
                        startRoom = rooms[i][j];
                    }
                }
            }
            stringBuilder.append("#").append(testCase).append(" ").append(startRoom).append(" ").append(maxMove).append("\n");
        }

        System.out.print(stringBuilder);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        rooms = new int[N][N];
        memo = new int[N][N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                rooms[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
//            System.out.println(Arrays.toString(rooms[i]));
        }
    }

    private static int find(int r, int c) {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }
        int maxCount = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N && rooms[nr][nc] == rooms[r][c] + 1) {
                maxCount = Math.max(maxCount, find(nr, nc) + 1);
            }
        }

        memo[r][c] = maxCount;
        return memo[r][c];
    }
}