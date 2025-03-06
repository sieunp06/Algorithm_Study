import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int T, N;

    private static int max, min;

    private static int[][] cheese;
    private static boolean[][] visited;
    private static boolean[][] cloned;

    private static int answer;

    // 상하좌우
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            for (int day = min - 1; day <= max; day++) {
                eat(day);
                answer = Math.max(answer, count());
            }
            stringBuilder.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        cheese = new int[N][N];
        visited = new boolean[N][N];

        answer = Integer.MIN_VALUE;

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                cheese[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                max = Math.max(max, cheese[i][j]);
                min = Math.min(min, cheese[i][j]);
            }
        }
    }

    private static void eat(int day) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cheese[i][j] == day) {
                    visited[i][j] = true;
                }
            }
        }
    }

    private static int count() {
        cloned = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            cloned[i] = visited[i].clone();
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!cloned[i][j]) {
                    count++;
                    cloned[i][j] = true;
                    countArea(i, j);
                }
            }
        }
        return count;
    }

    private static void countArea(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isIn(nr, nc) && !cloned[nr][nc]) {
                cloned[nr][nc] = true;
                countArea(nr, nc);
            }
        }
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
