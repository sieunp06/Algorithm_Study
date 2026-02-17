import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    private static int n, m;
    private static int[] numbers, indegree;
    private static boolean[][] adj;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            init();
            topologicalSort();
        }

        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        n = Integer.parseInt(bufferedReader.readLine());
        numbers = new int[n + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        adj = new boolean[n + 1][n + 1];
        indegree = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int higher = numbers[i];
            for (int j = i + 1; j < n; j++) {
                int lower = numbers[j];
                if (!adj[higher][lower]) {
                    adj[higher][lower] = true;
                    indegree[lower]++;
                }
            }
        }

        m = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            flipEdge(a, b);
        }
    }

    private static void flipEdge(int a, int b) {
        if (adj[a][b]) {
            adj[a][b] = false;
            adj[b][a] = true;
            indegree[b]--;
            indegree[a]++;
        } else {
            adj[b][a] = false;
            adj[a][b] = true;
            indegree[a]--;
            indegree[b]++;
        }
    }

    private static void topologicalSort() {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] indegCopy = Arrays.copyOf(indegree, indegree.length);

        for (int i = 1; i <= n; i++) {
            if (indegCopy[i] == 0) queue.add(i);
        }

        int[] order = new int[n];
        int idx = 0;
        boolean ambiguous = false;

        while (!queue.isEmpty()) {
            if (queue.size() > 1) ambiguous = true;

            int cur = queue.poll();
            order[idx++] = cur;

            for (int v = 1; v <= n; v++) {
                if (adj[cur][v]) {
                    indegCopy[v]--;
                    if (indegCopy[v] == 0) queue.add(v);
                }
            }
        }

        if (idx != n) {
            stringBuilder.append("IMPOSSIBLE").append("\n");
            return;
        }
        if (ambiguous) {
            stringBuilder.append("?").append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i > 0) stringBuilder.append(" ");
            stringBuilder.append(order[i]);
        }
        stringBuilder.append("\n");
    }
}
