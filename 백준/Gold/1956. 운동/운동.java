import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int V, E;
    private static int[][] path;
    private static final int INF = 4000001;

    public static void main(String[] args) throws IOException {
        init();
        floydWarshall();
        printResult();
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        V = Integer.parseInt(stringTokenizer.nextToken());
        E = Integer.parseInt(stringTokenizer.nextToken());

        path = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j) path[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            path[a][b] = c;
        }
    }

    private static void floydWarshall() {
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (path[i][j] > path[i][k] + path[k][j]) {
                        path[i][j] = path[i][k] + path[k][j];
                    }
                }
            }
        }
    }

    private static void printResult() {
        int minCycle = INF;

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) continue;
                if (path[i][j] != INF && path[j][i] != INF) {
                    minCycle = Math.min(minCycle, path[i][j] + path[j][i]);
                }
            }
        }

        System.out.println(minCycle == INF ? -1 : minCycle);
    }
}
