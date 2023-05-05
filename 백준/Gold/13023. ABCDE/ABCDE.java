import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] friend;
    public static boolean[] visited;
    public static boolean isArrive;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());   // 사람의 수
        int M = Integer.parseInt(st.nextToken());   // 친구 관계의 수

        friend = new ArrayList[N];
        visited = new boolean[N];

        isArrive = false;

        // 친구 관계 인접 그래프
        for (int i = 0; i < N; i++) {
            friend[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            friend[u].add(v);
            friend[v].add(u);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 1);
            if (isArrive) break;
        }
        if (isArrive) System.out.println("1");
        else System.out.println("0");
    }

    public static void DFS(int person, int depth) {
        if (depth == 5 || isArrive) {
            isArrive = true;
            return;
        }
        visited[person] = true;
        for (int i : friend[person]) {
            if (!visited[i])
                DFS(i, depth + 1);
        }
        visited[person] = false;
    }
}