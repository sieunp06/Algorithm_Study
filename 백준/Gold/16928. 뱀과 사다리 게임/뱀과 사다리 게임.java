import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N, M;
    static int answer;
    static int[] board = new int[101];
    static boolean[] visited = new boolean[101];

    static class Node {
        int idx, count;
        Node(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        System.out.println(answer);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        answer = Integer.MAX_VALUE;

        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            board[x] = y;
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());

            board[u] = v;
        }
    }

    static void bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(1, 0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.idx == 100) {
                answer = Math.min(answer, node.count);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = node.idx + i;

                if (next > 100) {
                    continue;
                }

                next = board[next];

                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new Node(next, node.count + 1));
                }
            }
        }
    }
}