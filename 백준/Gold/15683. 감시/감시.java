import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static List<CCTV> cctvs = new ArrayList<>();
    static int minBlindSpot = Integer.MAX_VALUE;

    // 상, 우, 하, 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][][] directions = {
            {},
            {{0}, {1}, {2}, {3}},                         // 1번
            {{0, 2}, {1, 3}},                             // 2번
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},             // 3번
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4번
            {{0, 1, 2, 3}}                                // 5번
    };

    static class CCTV {
        int x, y, type;
        CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        dfs(0, map);
        System.out.println(minBlindSpot);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= map[i][j] && map[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, map[i][j]));
                }
            }
        }
    }

    static void dfs(int depth, int[][] currentMap) {
        if (depth == cctvs.size()) {
            minBlindSpot = Math.min(minBlindSpot, countBlindSpot(currentMap));
            return;
        }

        CCTV cctv = cctvs.get(depth);
        for (int[] dirs : directions[cctv.type]) {
            int[][] copiedMap = copyMap(currentMap);
            for (int dir : dirs) {
                watch(copiedMap, cctv.x, cctv.y, dir);
            }
            dfs(depth + 1, copiedMap);
        }
    }

    static void watch(int[][] map, int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        while (inRange(nx, ny) && map[nx][ny] != 6) {
            if (map[nx][ny] == 0) map[nx][ny] = 7;
            nx += dx[dir];
            ny += dy[dir];
        }
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static int[][] copyMap(int[][] src) {
        int[][] dst = new int[N][M];
        for (int i = 0; i < N; i++) {
            dst[i] = src[i].clone();
        }
        return dst;
    }

    static int countBlindSpot(int[][] map) {
        int count = 0;
        for (int[] row : map) {
            for (int cell : row) {
                if (cell == 0) count++;
            }
        }
        return count;
    }
}
