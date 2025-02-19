import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    private static int T;   // 테스트케이스 개수

    private static int N;
    private static int[][] boards;
    private static boolean[][] visited;
    private static int idx = 0;

    // 우하좌상
    private static final int[] dr = {0, 1, 0, -1};
    private static final int[] dc = {1, 0, -1, 0};

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(bufferedReader.readLine());
            boards = new int[N][N];
            visited = new boolean[N][N];
            fillNumbers();

            stringBuilder.append("#").append(testCase).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    stringBuilder.append(boards[i][j]).append(" ");
                }
                stringBuilder.append("\n");
            }
        }
        System.out.print(stringBuilder);
    }

    private static void fillNumbers() {
        int num = 1;
        int r = 0; int c = 0;
        boards[r][c] = num++;
        visited[r][c] = true;

        while(num <= N * N) {
            r += dr[idx % 4];
            c += dc[idx % 4];

            if (r < 0 || r >= N || c < 0 || c >= N || visited[r][c]) {
                r -= dr[idx % 4];
                c -= dc[idx % 4];
                idx++;
                continue;
            }
            visited[r][c] = true;
            boards[r][c] = num;
            num++;
        }
    }
}