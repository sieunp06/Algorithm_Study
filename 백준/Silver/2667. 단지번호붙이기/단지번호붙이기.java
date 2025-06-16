import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int N, count;
    private static int[][] homes;
    private static boolean[][] visited;

    private static List<Integer> answer;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        init();
        findHome();
        printResult();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        homes = new int[N][N];
        visited = new boolean[N][N];
        answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                homes[i][j] = input.charAt(j) - '0';
            }
        }
    }

    private static void findHome() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (homes[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    answer.add(count);
                }
            }
        }
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isIn(nr, nc) && !visited[nr][nc] && homes[nr][nc] == 1) {
                dfs(nr, nc);
            }
        }
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    private static void printResult() {
        Collections.sort(answer);
        stringBuilder.append(answer.size()).append("\n");
        for (int size : answer) {
            stringBuilder.append(size).append("\n");
        }
        System.out.print(stringBuilder);
    }
}
