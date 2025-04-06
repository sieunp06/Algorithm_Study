import java.io.*;
import java.util.*;

public class Solution {
    static int T, N, M;
    static boolean[][] reachable;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(bufferedReader.readLine());

        for (int tc = 1; tc <= T; tc++) {
            init();
            floydWarshall();
            int result = countKnownOrders();
            stringBuilder.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.print(stringBuilder);
    }

    static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        M = Integer.parseInt(bufferedReader.readLine());

        reachable = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            reachable[a][b] = true;
        }
    }

    static void floydWarshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }
    }

    static int countKnownOrders() {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            int known = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (reachable[i][j] || reachable[j][i]) {
                    known++;
                }
            }
            if (known == N - 1) count++;
        }
        return count;
    }
}
