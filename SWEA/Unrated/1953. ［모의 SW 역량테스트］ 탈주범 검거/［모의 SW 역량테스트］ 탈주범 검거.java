import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, R, C, L;
    static int[][] tunnel;
    static boolean[][] visited;

    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int[][] tunnelDirections = {
            {},                 // 0: 없음
            {0, 1, 2, 3},       // 1: 상하좌우
            {0, 1},             // 2: 상하
            {2, 3},             // 3: 좌우
            {0, 3},             // 4: 상우
            {1, 3},             // 5: 하우
            {1, 2},             // 6: 하좌
            {0, 2}              // 7: 상좌
    };

    static int[] opposite = {1, 0, 3, 2};

    static int answer;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            bfs(R, C);
            stringBuilder.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        System.out.println(stringBuilder);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());  // 세로 크기
        M = Integer.parseInt(stringTokenizer.nextToken());  // 가로 크기
        R = Integer.parseInt(stringTokenizer.nextToken());  // 세로 위치
        C = Integer.parseInt(stringTokenizer.nextToken());  // 가로 위치
        L = Integer.parseInt(stringTokenizer.nextToken());  // 탈출 후 소요된 시간

        tunnel = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                tunnel[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        answer = 0;
    }

    static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c, 1});
        visited[r][c] = true;
        answer++;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cr = curr[0], cc = curr[1], time = curr[2];

            if (time >= L) continue;

            int type = tunnel[cr][cc];
            for (int dir : tunnelDirections[type]) {
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];

                if (!inRange(nr, nc) || visited[nr][nc] || tunnel[nr][nc] == 0) continue;

                int nextType = tunnel[nr][nc];
                if (canGo(dir, nextType)) {
                    visited[nr][nc] = true;
                    answer++;
                    queue.offer(new int[]{nr, nc, time + 1});
                }
            }
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static boolean canGo(int dir, int toType) {
        for (int d : tunnelDirections[toType]) {
            if (d == opposite[dir]) return true;
        }
        return false;
    }
}
