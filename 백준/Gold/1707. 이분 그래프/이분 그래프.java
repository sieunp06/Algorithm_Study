import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static int[] color;
    static boolean ok;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int K = Integer.parseInt(bufferedReader.readLine());

        while (K-- > 0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int V = Integer.parseInt(stringTokenizer.nextToken());
            int E = Integer.parseInt(stringTokenizer.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());

            color = new int[V + 1];
            ok = true;

            for (int i = 0; i < E; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) {
                    color[i] = 1;
                    dfs(i);
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }
    }

    static void dfs(int cur) {
        for (int nxt : graph.get(cur)) {
            if (!ok) return;

            if (color[nxt] == 0) {
                color[nxt] = -color[cur];
                dfs(nxt);
            } else if (color[nxt] == color[cur]) {
                ok = false;
                return;
            }
        }
    }
}
