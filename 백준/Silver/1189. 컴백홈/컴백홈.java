import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int R, C, K;
    private static char[][] map;
    private static boolean[][] visited;

    private static List<Integer> answers = new ArrayList<>();
    private static int answer = 0;

    // 상하좌우
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);
        
        for (int num : answers) {
            if (num == K) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void init() throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = bufferedReader.readLine().toCharArray();
        }
    }

    private static void dfs(int r, int c, int distance) {
        if (r == 0 && c == C - 1) {
            answers.add(distance);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] != 'T') {
                visited[nr][nc] = true;
                dfs(nr, nc, distance + 1);
                visited[nr][nc] = false;
            }
        }
    }

    private static boolean isIn(int nr, int nc) {
        return nr >= 0 && nr < R && nc >= 0 && nc < C;
    }
}