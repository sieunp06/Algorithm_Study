import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N, M;
    static int[][] map;

    static int maxSum;

    static int[][][] tetromino = {
            // I
            {{0,0},{0,1},{0,2},{0,3}},
            {{0,0},{1,0},{2,0},{3,0}},
            // O
            {{0,0},{0,1},{1,0},{1,1}},
            // L
            {{0,0},{1,0},{2,0},{2,1}},
            {{0,0},{0,1},{0,2},{1,0}},
            {{0,0},{0,1},{1,1},{2,1}},
            {{0,0},{1,0},{1,1},{1,2}},
            {{0,0},{1,0},{2,0},{2,-1}},
            {{0,0},{0,1},{0,2},{-1,2}},
            {{0,0},{0,1},{1,0},{2,0}},
            {{0,0},{0,1},{0,2},{1,2}},
            {{0,0},{1,0},{1,1},{2,1}},
            {{0,0},{0,1},{-1,1},{-2,1}},
            {{0,0},{0,1},{1,0},{2,0}},
            // Z
            {{0,0},{0,1},{1,1},{1,2}},
            {{0,0},{1,0},{1,-1},{2,-1}},
            {{0,0},{0,1},{-1,1},{-1,2}},
            {{0,0},{1,0},{1,1},{2,1}},
            // T
            {{0,0},{0,1},{0,2},{1,1}},
            {{0,0},{1,0},{2,0},{1,1}},
            {{0,0},{1,-1},{1,0},{1,1}},
            {{0,0},{1,0},{2,0},{1,-1}}
    };

    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.print(stringBuilder);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    static void solve() {
        maxSum = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int[][] shape : tetromino) {
                    int sum = 0;
                    boolean isValid = true;

                    for (int[] block : shape) {
                        int nr = r + block[0];
                        int nc = c + block[1];

                        if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                            isValid = false;
                            break;
                        }
                        sum += map[nr][nc];
                    }

                    if (isValid && sum > maxSum) {
                        maxSum = sum;
                    }
                }
                checkT(r, c);
            }
        }

        stringBuilder.append(maxSum).append("\n");
    }

    static void checkT(int r, int c) {
        int center = map[r][c];
        int wingCount = 0;
        int minWing = Integer.MAX_VALUE;
        int sum = center;

        // 상하좌우
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                sum += map[nr][nc];
                minWing = Math.min(minWing, map[nr][nc]);
                wingCount++;
            }
        }

        if (wingCount == 4) {
            sum -= minWing;
        }

        if (wingCount >= 3) {
            maxSum = Math.max(maxSum, sum);
        }
    }
}
