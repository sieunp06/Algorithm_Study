import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] isVisited;

    static List<Integer> answer;

    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        findHome();
        printResult();
    }

    static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        answer = new ArrayList<>();
    }

    static void findHome() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    answer.add(bfs(i, j));
                }
            }
        }
    }

    static int bfs(int r, int c) {
        int count = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {r, c});
        isVisited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (isIn(nr, nc) && !isVisited[nr][nc] && map[nr][nc] == 1) {
                    isVisited[nr][nc] = true;
                    queue.add(new int[] {nr, nc});
                    count++;
                }
            }
        }
        return count;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    static void printResult() {
        Collections.sort(answer);
        System.out.println(answer.size());
        for (int num : answer) {
            System.out.println(num);
        }
    }
}
