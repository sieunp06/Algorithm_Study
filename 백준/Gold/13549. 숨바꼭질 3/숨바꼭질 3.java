import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int N, K;
    private static int[] dist;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        System.out.println(dist[K]);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        dist = new int[100_001];
        Arrays.fill(dist, INF);
    }

    private static void bfs() {
        Deque<Integer> deque = new ArrayDeque<>();
        dist[N] = 0;
        deque.add(N);

        while (!deque.isEmpty()) {
            int now = deque.poll();

            if (now * 2 < 100_001 && dist[now * 2] > dist[now]) {
                dist[now * 2] = dist[now];;
                deque.addFirst(now * 2);
            }

            if (now - 1 >= 0 && dist[now - 1] > dist[now] + 1) {
                dist[now - 1] = dist[now] + 1;
                deque.addLast(now - 1);
            }

            if (now + 1 < 100_001 && dist[now + 1] > dist[now] + 1) {
                dist[now + 1] = dist[now] + 1;
                deque.addLast(now + 1);
            }
        }
    }
}
