import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int M, N, V;
    private static List<Integer>[] lists;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(V);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        V = Integer.parseInt(stringTokenizer.nextToken());

        lists = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            lists[a].add(b);
            lists[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(lists[i]);
        }
    }

    private static void dfs(int num) {
        if (visited[num]) {
            return;
        }
        visited[num] = true;
        System.out.print(num + " ");
        for (int now : lists[num]) {
            if (!visited[now]) {
                dfs(now);
            }
        }
    }

    private static void bfs(int num) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(num);
        visited[num] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int n : lists[now]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
