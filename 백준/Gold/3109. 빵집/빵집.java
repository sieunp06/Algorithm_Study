import java.io.*;
import java.util.*;

public class Main {
    private static int R, C;
    private static char[][] pipes;
    private static boolean[][] visited;

    private static int count = 0;

    // 오른쪽, 우상, 우하
    private static int[] dr = {-1, 0, 1};

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < R; i++) {
            find(i, 0);
        }
        System.out.println(count);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        pipes = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = bufferedReader.readLine();
            pipes[i] = input.toCharArray();
        }
    }

    private static boolean find(int r, int c) {
        if (c == C - 1) {
            count++;
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nr = r + dr[i];
            int nc = c + 1;

            if (isIn(nr, nc) && !isBuilding(nr, nc) && !visited[nr][nc]) {
                visited[nr][nc] = true;
                if (find(nr, nc)) {
                    return true;
                }

            }
        }
        return false;
    }

    private static boolean isIn(int nr, int nc) {
        return nr >= 0 && nr < R && nc >= 0 && nc < C;
    }

    private static boolean isBuilding(int nr, int nc) {
        return pipes[nr][nc] == 'x';
    }
}
