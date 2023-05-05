import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    static int M;

    static boolean[][] visited;
    static int[][] mirro;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        mirro = new int[N][M];

        for (int i = 0; i < N; i++) {
            String text = bf.readLine();
            for (int j = 0; j < M; j++) {
                mirro[i][j] = Integer.parseInt(text.substring(j, j + 1));
            }
        }

        BFS(0, 0);
        System.out.println(mirro[N - 1][M - 1]);
    }
    public static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int now[] = q.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (mirro[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        mirro[x][y] = mirro[now[0]][now[1]] + 1;
                        q.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}