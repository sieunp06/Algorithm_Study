import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    private static int N, M;
    private static int[][] maze, distance;

    private static final int INF = Integer.MAX_VALUE;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static class Node implements Comparable<Node> {

        int r, c, cost;

        Node (int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

    }

    public static void main(String[] args) throws IOException {
        init();
        dijkstra();
        System.out.println(distance[N - 1][M - 1]);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());

        maze = new int[N][M];
        distance = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = input.charAt(j) - '0';
                distance[i][j] = INF;
            }
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(0, 0, 0));
        distance[0][0] = 0;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            int r = node.r;
            int c = node.c;
            int cost = node.cost;

            if (distance[r][c] < cost) continue;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (isIn(nr, nc)) {
                    if (distance[nr][nc] > cost + maze[nr][nc]) {
                        distance[nr][nc] = cost + maze[nr][nc];
                        priorityQueue.add(new Node(nr, nc, distance[nr][nc]));
                    }
                }
            }
        }
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
