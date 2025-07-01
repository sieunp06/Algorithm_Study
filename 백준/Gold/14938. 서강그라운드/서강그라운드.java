import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int n, m, r;
    private static int[][] path;
    private static int[] items;

    public static void main(String[] args) throws IOException {
        init();
        floydWarshall();
        System.out.println(sum());
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        r = Integer.parseInt(stringTokenizer.nextToken());

        path = new int[n + 1][n + 1];
        items = new int[n + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            Arrays.fill(path[i], 1_000_000_00);
            path[i][i] = 0;
        }

        for (int i = 0; i < r; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int I = Integer.parseInt(stringTokenizer.nextToken());

            path[a][b] = Math.min(path[a][b], I);
            path[b][a] = Math.min(path[b][a], I);
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

    private static int sum() {
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int j = 1; j <= n; j++) {
                if (path[i][j] <= m) {
                    total += items[j];
                }
            }
            max = Math.max(max, total);
        }
        return max;
    }
}
