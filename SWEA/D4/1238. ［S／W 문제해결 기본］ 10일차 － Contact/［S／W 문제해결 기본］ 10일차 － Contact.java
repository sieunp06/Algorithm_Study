import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    private static int len, start;
    private static final int MAX = 100;

    private static int[] parent = new int[MAX + 1];
    private static int[] depth = new int[MAX + 1];
    private static boolean[] visited = new boolean[MAX + 1];
    private static Map<Integer, List<Integer>> graph = new HashMap<>();

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        for (int testCase = 1; testCase <= 10; testCase++) {
            init();
            readInput();
            solve();
            int answer = getAnswer();
            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }

    private static void init() {
        for (int i = 0; i <= MAX; i++) {
            parent[i] = i;
            depth[i] = 0;
            visited[i] = false;
            graph.put(i, new ArrayList<>());
        }
    }

    private static void readInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        len = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len / 2; i++) {
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to); // 단방향
        }
    }

    private static void solve() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        depth[start] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : graph.get(curr)) {
                if (!visited[next]) {
                    union(curr, next);
                    visited[next] = true;
                    depth[next] = depth[curr] + 1;
                    queue.offer(next);
                }
            }
        }
    }

    private static int getAnswer() {
        int maxDepth = -1;
        int result = -1;

        for (int i = 1; i <= MAX; i++) {
            if (depth[i] > maxDepth) {
                maxDepth = depth[i];
                result = i;
            } else if (depth[i] == maxDepth && i > result) {
                result = i;
            }
        }
        return result;
    }

    private static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb)
            parent[pb] = pa;
    }
}
