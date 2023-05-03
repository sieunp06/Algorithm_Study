import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] closeList;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());   // N: 정점의 개수
        int M = Integer.parseInt(st.nextToken());   // M: 간선의 개수

        visited = new boolean[N + 1];   // 방문 기록 저장 배열
        closeList = new ArrayList[N + 1];    // 인접 리스트

        // 인접 리스트 초기화
        for (int i = 1; i <= N; i++)
            closeList[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            closeList[u].add(v);
            closeList[v].add(u);
        }

        int count = 0;

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    private static void DFS(int v) {
        if (visited[v]) return;
        visited[v] = true;
        for (int i : closeList[v]) {
            if (!visited[i])
                DFS(i);
        }
    }
}