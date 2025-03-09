import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    private static int V, E;

    public static int[] indegree;
    public static List<Integer>[] graph;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws Exception {
        for (int testCase = 1; testCase <= 10; testCase++) {
            init();
            stringBuilder.append("#").append(testCase).append(" ");
            for (int num : topologySort()) {
                stringBuilder.append(num).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        V = Integer.parseInt(stringTokenizer.nextToken());
        E = Integer.parseInt(stringTokenizer.nextToken());

        indegree = new int[V + 1];
        graph = new List[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < E; i++) {
            int v = Integer.parseInt(stringTokenizer.nextToken());
            int e = Integer.parseInt(stringTokenizer.nextToken());

            graph[v].add(e);
            indegree[e] += 1;
        }
    }

    private static List<Integer> topologySort() {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            result.add(now);
            for (int i = 0; i < graph[now].size(); i++) {
                indegree[graph[now].get(i)]--;
                if (indegree[graph[now].get(i)] == 0) {
                    queue.add(graph[now].get(i));
                }
            }
        }
        return result;
    }
}