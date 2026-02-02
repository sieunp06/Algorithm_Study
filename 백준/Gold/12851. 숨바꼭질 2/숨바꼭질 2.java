import java.io.*;
import java.util.*;

public class Main {
    private static int N, K;
    private static int[] dist = new int[100000 + 1];
    private static int[] count = new int[100000 + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        bfs();

        System.out.println(dist[K]);
        System.out.println(count[K]);
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        Arrays.fill(dist, -1);

        queue.add(N);
        dist[N] = 0;
        count[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next < 0 || next > 100000) continue;

                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    count[next] = count[now];
                    queue.add(next);
                }
                else if (dist[next] == dist[now] + 1) {
                    count[next] += count[now];
                }
            }
        }
    }
}
