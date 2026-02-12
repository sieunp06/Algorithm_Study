import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[] parent;
    private static boolean[] hasCycle;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int testCase = 1;
        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            n = Integer.parseInt(stringTokenizer.nextToken());
            m = Integer.parseInt(stringTokenizer.nextToken());

            if (n == 0 && m == 0) {
                System.out.print(stringBuilder);
                return;
            }

            parent = new int[n + 1];
            hasCycle = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < m; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());

                union(a, b);
            }

            int answer = 0;
            boolean[] isCounted = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                int root = find(i);
                if (!hasCycle[root]) {
                    if (!isCounted[root]) {
                        answer++;
                        isCounted[root] = true;
                    }
                }
            }

            stringBuilder.append("Case ").append(testCase++).append(": ");
            if (answer == 0) {
                stringBuilder.append("No trees.");
            } else if (answer == 1) {
                stringBuilder.append("There is one tree.");
            } else {
                stringBuilder.append("A forest of ").append(answer).append(" trees.");
            }
            stringBuilder.append("\n");
        }
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            hasCycle[rootA] = true;
            return;
        }
        parent[rootA] = rootB;
        hasCycle[rootB] = hasCycle[rootA] || hasCycle[rootB];
    }
}
