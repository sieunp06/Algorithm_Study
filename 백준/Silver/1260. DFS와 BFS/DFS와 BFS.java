import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 정점의 개수 N
        int M = Integer.parseInt(st.nextToken());   // 간선의 개수 M
        int V = Integer.parseInt(st.nextToken());   // 탐색을 시작할 정점의 번호 V

        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A].add(B);
            list[B].add(A);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        visited = new boolean[N + 1];
        DFS(V);
        System.out.println();
        visited = new boolean[N + 1];
        BFS(V);
    }

    private static void DFS(int num) {
        if (visited[num]) {
            return;
        }
        visited[num] = true;
        System.out.print(num + " ");
        for (int i : list[num]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    private static void BFS(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;

        while (!queue.isEmpty()) {
            int nowNum = queue.poll();
            System.out.print(nowNum + " ");
            for (int i : list[nowNum]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}

