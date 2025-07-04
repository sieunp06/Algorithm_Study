import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N, M;
    static char[][] campus;
    static boolean[][] visited;
    static int[] start = new int[2];
    static int result = 0;

    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        System.out.println(result == 0 ? "TT" : result);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        campus = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = input.charAt(j);
                if (campus[i][j] == 'I') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
    }

    static void bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(start[0], start[1]));
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];

                if (isIn(nr, nc) && !visited[nr][nc] && campus[nr][nc] != 'X') {
                    if (campus[nr][nc] == 'P') {
                        result++;
                    }
                    queue.add(new Node(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
