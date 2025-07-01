import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int n, m;
    private static List<Node> nodes = new ArrayList<>();
    private static long[] distance;
    private static int[] prev;

    private static class Node {
        int from, to, cost;
        Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        if (bellmanFord()) {
            System.out.println(-1);
        } else {
            printResult();
        }
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            int w = Integer.parseInt(stringTokenizer.nextToken());

            nodes.add(new Node(u, v, w));
        }

        distance = new long[n + 1];
        prev = new int[n + 1];
    }

    private static boolean bellmanFord() {
        Arrays.fill(distance, Long.MIN_VALUE);
        distance[1] = 0;

        for (int i = 1; i <= n - 1; i++) {
            for (Node node : nodes) {
                if (distance[node.from] != Long.MIN_VALUE
                        && distance[node.to] < distance[node.from] + node.cost) {
                    distance[node.to] = distance[node.from] + node.cost;
                    prev[node.to] = node.from;
                }
            }
        }

        for (Node node : nodes) {
            if (distance[node.from] != Long.MIN_VALUE
                    && distance[node.to] < distance[node.from] + node.cost) {
                if (canReach(node.to)) {
                    return true; // 양수 사이클 경로를 통해 N 도달 가능
                }
            }
        }
        return false;
    }


    private static boolean canReach(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == n) return true;
            for (Node node : nodes) {
                if (node.from == curr && !visited[node.to]) {
                    visited[node.to] = true;
                    queue.add(node.to);
                }
            }
        }
        return false;
    }

    private static List<Integer> getPath() {
        List<Integer> path = new ArrayList<>();
        int curr = n;
        while (curr != 0) {
            path.add(curr);
            curr = prev[curr];
        }
        Collections.reverse(path);
        return path;
    }

    private static void printResult() {
        for (int p : getPath()) {
            stringBuilder.append(p).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
