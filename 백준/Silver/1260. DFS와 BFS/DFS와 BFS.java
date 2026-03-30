import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, V;
    private static List<Integer>[] lists;
    private static boolean[] isVisted;

    public static void main(String[] args) throws Exception {
        init();
        makeAnswer(dfs(V));
        makeAnswer(bfs(V));
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

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

    private static List<Integer> dfs(int start) {
        List<Integer> result = new ArrayList<>();
        isVisted = new boolean[N + 1];

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int target = stack.pop();

            if (isVisted[target]) continue;
            isVisted[target] = true;
            result.add(target);

            for (int i = lists[target].size() - 1; i >= 0; i--) {
                int next = lists[target].get(i);
                if (!isVisted[next]) {
                    stack.push(next);
                }
            }
        }
        return result;
    }

    private static List<Integer> bfs(int start) {
        List<Integer> result = new ArrayList<>();
        isVisted = new boolean[N + 1];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int target = queue.poll();

            if (isVisted[target]) continue;
            isVisted[target] = true;
            result.add(target);

            for (int num : lists[target]) {
                if (!isVisted[num]) {
                    queue.add(num);
                }
            }
        }
        return result;
    }

    private static void makeAnswer(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : list) {
            stringBuilder.append(num).append(" ");
        }
        stringBuilder.append("\n");
        System.out.print(stringBuilder);
    }
}
