import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int N, M, W;
    private static List<Node> nodes;
    private static long[] distance;
    private static final int INF = Integer.MAX_VALUE;

    private static class Node {
        int S, E, T;
        Node(int S, int E, int T) {
            this.S = S;
            this.E = E;
            this.T = T;
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int tc = 1; tc <= T; tc++) {
            init();
            stringBuilder.append(bellmanFord() ? "YES" : "NO").append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        W = Integer.parseInt(stringTokenizer.nextToken());

        nodes = new ArrayList<>();
        distance = new long[N + 1];

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int S = Integer.parseInt(stringTokenizer.nextToken());
            int E = Integer.parseInt(stringTokenizer.nextToken());
            int T = Integer.parseInt(stringTokenizer.nextToken());

            nodes.add(new Node(S, E, T));
            nodes.add(new Node(E, S, T));
        }

        for (int i = 0; i < W; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int S = Integer.parseInt(stringTokenizer.nextToken());
            int E = Integer.parseInt(stringTokenizer.nextToken());
            int T = Integer.parseInt(stringTokenizer.nextToken());

            nodes.add(new Node(S, E, -T));
        }
    }

    private static boolean bellmanFord() {
        Arrays.fill(distance, 0);
        for (int i = 1; i <= N; i++) {
            for (Node node : nodes) {
                if (distance[node.E] > distance[node.S] + node.T) {
                    distance[node.E] = distance[node.S] + node.T;
                    if (i == N) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
