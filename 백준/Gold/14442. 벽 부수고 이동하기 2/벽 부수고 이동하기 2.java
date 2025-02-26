import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static int K;

    private static boolean[][][] visited;
    private static int[][] map;

    // 상하좌우
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(bfs());
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N][M][K + 1];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
    }

    private static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.r == N - 1 && node.c == M - 1) {
                return node.move;
            }

            for (int i = 0; i < 4; i++) {
                int now_r = node.r + dr[i];
                int now_c = node.c + dc[i];

                if (isIn(now_r, now_c)) {
                    if (map[now_r][now_c] == 0 && !visited[now_r][now_c][node.count]) {
//                    queue.add(new Node(now_r, now_c, node.move))
                        visited[now_r][now_c][node.count] = true;
                        queue.add(new Node(now_r, now_c, node.count, node.move + 1));
                    }
                    if (map[now_r][now_c] == 1 && node.count < K && !visited[now_r][now_c][node.count + 1]) {
                        visited[now_r][now_c][node.count + 1] = true;
                        queue.add(new Node(now_r, now_c, node.count + 1, node.move + 1));
                    }

                }
            }
        }
        return -1;
    }

    private static boolean isIn(int now_r, int now_c) {
        return now_r >= 0 && now_r < N && now_c >= 0 && now_c < M;
    }
}

class Node {
    int r;
    int c;
    int count;
    int move;

    Node(int r, int c, int count, int move) {
        this.r = r;
        this.c = c;
        this.count = count;
        this.move = move;
    }
}
