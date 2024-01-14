import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> answer;
    static int[] visited;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 도시의 개수 N
        int M = Integer.parseInt(st.nextToken());   // 도로의 개수 M
        int K = Integer.parseInt(st.nextToken());   // 거리 정보 K
        int X = Integer.parseInt(st.nextToken());   // 출발 도시의 번호 X

        answer = new ArrayList<>();
        visited = new int[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            visited[i] = -1;
        }

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A].add(B);
        }

        BFS(X);

        for (int i = 0; i <= N; i++) {
            if (visited[i] == K) {
                answer.add(i);
            }
        }

        if (answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);
        }

        for (int num : answer) {
            System.out.println(num);
        }
    }

    private static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node]++;

        while (!q.isEmpty()) {
            int now_node = q.poll();
            for (int i: list[now_node]) {
                if (visited[i] == -1) {
                    visited[i] = visited[now_node] + 1;
                    q.add(i);
                }
            }
        }
    }
}

