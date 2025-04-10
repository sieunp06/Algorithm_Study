import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, W, H;
    static int[][] wall;
    static int[][] clonedWall;
    static int totalBrick;

    static List<int[]> dropOffSpots;
    static int[] dropOffSpot;

    static int answer;

    static class Location {
        int r, c, num;

        Location(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "r=" + r +
                    ", c=" + c +
                    ", num=" + num +
                    '}';
        }
    }

    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            combination(0);
            explode();
            stringBuilder.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        W = Integer.parseInt(stringTokenizer.nextToken());
        H = Integer.parseInt(stringTokenizer.nextToken());

        wall = new int[H][W];
        dropOffSpot = new int[N];
        dropOffSpots = new ArrayList<>();
        answer = 180;

        totalBrick = 0;
        for (int i = 0; i < H; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < W; j++) {
                wall[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (wall[i][j] != 0) {
                    totalBrick++;
                }
            }
        }
    }

    static void combination(int depth) {
        if (depth == N) {
            dropOffSpots.add(dropOffSpot.clone());
            return;
        }

        for (int i = 0; i < W; i++) {
            dropOffSpot[depth] = i;
            combination(depth + 1);
        }
    }

    static void explode() {
        for (int[] spot : dropOffSpots) {
            clonedWall = new int[H][W];

            for (int i = 0; i < H; i++) {
                clonedWall[i] = wall[i].clone();
            }

            for (int drop : spot) {
                Queue<Location> queue = new ArrayDeque<>();
                boolean[][] visited = new boolean[H][W];

                Location dropPoint = checkHighestNumber(drop);

                if (dropPoint != null) {
                    queue.add(dropPoint);
                }
                else continue;

                while (!queue.isEmpty()) {
                    Location now = queue.poll();

                    if (clonedWall[now.r][now.c] == 0) {
                        continue;
                    }

                    int range = clonedWall[now.r][now.c];

                    for (int j = 0; j < range; j++) {
                        for (int i = 0; i < 4; i++) {
                            int nr = now.r + dr[i] * j;
                            int nc = now.c + dc[i] * j;

                            if (!isIn(nr, nc) || visited[nr][nc]) continue;
                            visited[nr][nc] = true;
                            queue.add(new Location(nr, nc, clonedWall[nr][nc]));
                        }
                    }
                }

                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        if (visited[i][j]) {
                            clonedWall[i][j] = 0;
                        }
                    }
                }

                stack();
            }

            answer = Math.min(answer, count());
        }
    }

    static int count() {
        int total = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (clonedWall[i][j] != 0) {
                    total++;
                }
            }
        }
        return total;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < H && c < W;
    }

    static Location checkHighestNumber(int num) {
        for (int i = 0; i < H; i++) {
            if (clonedWall[i][num] != 0) {
                return new Location(i, num, clonedWall[i][num]);
            }
        }
        return null;
    }

    static void stack() {
        for (int i = 0; i < W; i++) {
            Stack<Integer> queue = new Stack<>();

            for (int j = 0; j < H; j++) {
                if (clonedWall[j][i] != 0) {
                    queue.add(clonedWall[j][i]);
                }
            }

            for (int j = 0; j < H; j++) {
                clonedWall[j][i] = 0;
            }

            for (int j = H - 1; j >= 0; j--) {
                if (queue.isEmpty()) {
                    break;
                }
                clonedWall[j][i] = queue.pop();
            }
        }
    }
}