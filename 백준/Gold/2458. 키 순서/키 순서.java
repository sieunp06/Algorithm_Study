import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int N, M;
    private static int[][] person;

    public static void main(String[] args) throws IOException {
        init();
        floydWarshall();
        System.out.println(count());
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        person = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            person[a][b] = 1;
        }
    }

    private static void floydWarshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (person[i][k] == 1 && person[k][j] == 1) {
                        person[i][j] = 1;
                    }
                }
            }
        }
    }

    private static int count() {
        int result = 0;

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (person[i][j] == 1 || person[j][i] == 1) {
                    cnt++;
                }
            }
            if (cnt == N - 1) {
                result++;
            }
        }

        return result;
    }
}
