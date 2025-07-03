import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;
    
    private static int N;
    private static int[][] persons;
    private static final int INF = 1_000_000_00;

    public static void main(String[] args) throws IOException {
        init();
        floydWarshall();
        processResult();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());

        persons = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(persons[i], INF);
            persons[i][i] = 0;
        }

        while (true) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            if (a == -1 && b == -1) break;

            persons[a][b] = 1;
            persons[b][a] = 1;
        }
    }

    private static void floydWarshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) continue;
                    if (persons[i][j] > persons[i][k] + persons[k][j]) {
                        persons[i][j] = persons[i][k] + persons[k][j];
                    }
                }
            }
        }
    }

    private static void processResult() {
        int[] scores = new int[N + 1];
        int minScore = INF;

        for (int i = 1; i <= N; i++) {
            int max = 0;
            for (int j = 1; j <= N; j++) {
                max = Math.max(max, persons[i][j]);
            }
            scores[i] = max;
            minScore = Math.min(minScore, max);
        }

        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (scores[i] == minScore) {
                candidates.add(i);
            }
        }

        stringBuilder.append(minScore).append(" ").append(candidates.size()).append("\n");
        for (int c : candidates) {
            stringBuilder.append(c).append(" ");
        }
        stringBuilder.append("\n");
        System.out.print(stringBuilder);
    }
}
