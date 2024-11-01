import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Integer>[] lists;
    private static boolean[] visited;
    private static int[] counts;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        lists = new ArrayList[N + 1];
        counts = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            lists[a].add(b);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }

        StringBuilder stringBuilder = new StringBuilder();

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, counts[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (counts[i] == max) {
                stringBuilder.append(i).append(" ");
            }
        }

        System.out.println(stringBuilder);
    }

    private static void bfs(int target) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(target);
        visited[target] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i : lists[now]) { 
                if (visited[i]) continue;
                counts[i]++;
                visited[i] = true;
                q.add(i);
            }
        }
    }
}