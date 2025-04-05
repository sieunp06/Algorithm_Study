import java.io.*;
import java.util.*;

public class Main {
    static int testCase = 1;
    static int N;
    static int[][] cave;
    static int[][] dist;
    static final int INF = Integer.MAX_VALUE;

    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int r, c, cost;

        Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        while (true) {
            N = Integer.parseInt(bufferedReader.readLine());
            if (N == 0) break;
            init();
            dijkstra(0, 0);
            printResult();
        }
        System.out.println(stringBuilder);
    }

    static void init() throws IOException {
        cave = new int[N][N];
        dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                cave[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                dist[i][j] = INF;
            }
        }
    }

    static void dijkstra(int r, int c) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0][0] = cave[0][0];
        pq.offer(new Node(0, 0, cave[0][0]));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (dist[current.r][current.c] < current.cost) continue;

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (!isIn(nr, nc)) continue;

                int newCost = dist[current.r][current.c] + cave[nr][nc];

                if (newCost < dist[nr][nc]) {
                    dist[nr][nc] = newCost;
                    pq.offer(new Node(nr, nc, newCost));
                }
            }
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    static void printResult() {
        stringBuilder.append("Problem ").append(testCase++).append(": ").append(dist[N - 1][N - 1]).append('\n');
    }
}
