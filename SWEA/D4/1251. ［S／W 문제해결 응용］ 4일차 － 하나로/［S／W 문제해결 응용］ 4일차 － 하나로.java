import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] x, y;
    static double E;
    static boolean[] visited;
    static double[] minEdge;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;
    static class Node implements Comparable<Node> {
        int idx;
        double cost;

        public Node(int idx, double cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            stringBuilder.append("#").append(testCase).append(" ").append(Math.round(prim())).append("\n");
        }
        System.out.println(stringBuilder);
    }

    static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        x = new int[N];
        y = new int[N];
        visited = new boolean[N];
        minEdge = new double[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            y[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        E = Double.parseDouble(bufferedReader.readLine());
    }

    static double prim() {
        Arrays.fill(minEdge, Double.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        minEdge[0] = 0;
        pq.add(new Node(0, 0));

        double result = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.idx]) continue;

            visited[now.idx] = true;
            result += now.cost;
            count++;

            if (count == N) break;

            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    double dist = getDist(now.idx, i);
                    if (minEdge[i] > dist) {
                        minEdge[i] = dist;
                        pq.add(new Node(i, dist));
                    }
                }
            }
        }

        return result;
    }

    static double getDist(int a, int b) {
        long dx = x[a] - x[b];
        long dy = y[a] - y[b];
        return (dx * dx + dy * dy) * E;
    }
}
