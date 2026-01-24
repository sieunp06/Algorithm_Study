import java.io.*;
import java.util.*;

public class Main {
    private static int T;
    private static List<Node>[] lists;
    private static final int INF = Integer.MAX_VALUE;

    private static class Node {
        int to, weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        T = Integer.parseInt(bufferedReader.readLine());
        for (int tc = 0; tc < T; tc++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());  // 정점 개수
            int m = Integer.parseInt(stringTokenizer.nextToken());  // 간선 개수
            int t = Integer.parseInt(stringTokenizer.nextToken());  // 목적지 후보의 개수

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int s = Integer.parseInt(stringTokenizer.nextToken());  // 출발지
            int g = Integer.parseInt(stringTokenizer.nextToken());  // 필수 이동 간선
            int h = Integer.parseInt(stringTokenizer.nextToken());

            lists = new List[n + 1];

            for (int i = 1; i <= n; i++) {
                lists[i] = new ArrayList<>();
            }

            int wGH = 0;

            for (int i = 0; i < m; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());
                int d = Integer.parseInt(stringTokenizer.nextToken());

                lists[a].add(new Node(b, d));
                lists[b].add(new Node(a, d));

                if ((a == g && b == h) || (a == h && b == g)) {
                    wGH = d;
                }
            }

            int[] distS = dijkstra(s, n);
            int[] distG = dijkstra(g, n);
            int[] distH = dijkstra(h, n);

            int[] candidates = new int[t];
            for (int i = 0; i < t; i++) {
                candidates[i] = Integer.parseInt(bufferedReader.readLine());
            }

            List<Integer> answer = new ArrayList<>();
            for (int x : candidates) {
                if (distS[x] == INF) continue;

                if (distS[x] == distS[g] + wGH + distH[x] ||
                        distS[x] == distS[h] + wGH + distG[x]) {
                    answer.add(x);
                }
            }

            Collections.sort(answer);
            for (int x : answer) stringBuilder.append(x).append(" ");
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static int[] dijkstra(int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.weight > dist[cur.to]) continue;

            for (Node next : lists[cur.to]) {
                int nd = dist[cur.to] + next.weight;
                if (dist[next.to] > nd) {
                    dist[next.to] = nd;
                    pq.add(new Node(next.to, nd));
                }
            }
        }
        return dist;
    }
}
