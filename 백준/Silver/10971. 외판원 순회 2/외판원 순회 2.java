import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] cities;
    private static boolean[] visited;
    private static int answer;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            backtracking(1, i, i, 0);
        }

        System.out.println(answer);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        cities = new int[N][N];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                cities[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    private static void backtracking(int depth, int start, int now, int cost) {
        if (cost >= answer) {
            return;
        }
        if (depth == N) {
            if (cities[now][start] != 0) {
                answer = Math.min(answer, cost + cities[now][start]);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && cities[now][i] != 0) {
                visited[i] = true;
                backtracking(depth + 1, start, i, cost + cities[now][i]);
                visited[i] = false;
            }
        }
    }
}