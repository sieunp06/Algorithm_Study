import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    private static int T;
    private static int D, W, K;
    private static int[][] cells;
    private static int[][] cloned;

    private static int answer;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            dfs(0, 0);
            stringBuilder.append("#").append(testCase).append(" ").append(answer == Integer.MAX_VALUE ? 0 : answer).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        D = Integer.parseInt(stringTokenizer.nextToken());  // 보호 필름의 두께
        W = Integer.parseInt(stringTokenizer.nextToken());  // 가로 크기
        K = Integer.parseInt(stringTokenizer.nextToken());  // 합격 기준

        cells = new int[D][W];
        cloned = new int[D][W];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < D; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < W; j++) {
                cells[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    private static void dfs(int r, int count) {
        if (count >= answer) {
            return;
        }

        if (r == D) {
            if (check()) {
                answer = count;
            }
            return;
        }

        int[] tmp = cells[r].clone();
        dfs(r + 1, count);
        Arrays.fill(cells[r], 0);
        dfs(r + 1, count + 1);
        Arrays.fill(cells[r], 1);
        dfs(r + 1, count + 1);

        cells[r] = tmp;
    }

    private static boolean check() {
        loop: for (int i = 0; i < W; i++) {
            int count = 1;
            for (int j = 0; j < D - 1; j++) {
                if (cells[j][i] == cells[j + 1][i]) {
                    count++;
                } else {
                    count = 1;
                }

                if (count >= K) {
                    continue loop;
                }
            }
            return false;
        }
        return true;
    }
}