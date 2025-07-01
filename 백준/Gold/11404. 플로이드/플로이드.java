import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int n, m;
    private static int[][] path;
    private static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        init();
        floydWarshall();
        printResult();
    }

    private static void init() throws IOException {
        n = Integer.parseInt(bufferedReader.readLine());
        m = Integer.parseInt(bufferedReader.readLine());

        path = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(path[i], INF);
            path[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int cost = Integer.parseInt(stringTokenizer.nextToken());

            path[from][to] = Math.min(path[from][to], cost);
        }
    }

    private static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (path[i][j] > path[i][k] + path[k][j]) {
                        path[i][j] = path[i][k] + path[k][j];
                    }
                }
            }
        }
    }

    private static void printResult() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (path[i][j] == INF) stringBuilder.append("0 ");
                else stringBuilder.append(path[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}
