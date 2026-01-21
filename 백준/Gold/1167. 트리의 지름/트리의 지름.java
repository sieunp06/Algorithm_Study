import java.io.*;
import java.util.*;

public class Main {
    private static int V;
    private static List<Node>[] lists;
    private static boolean[] visited;
    private static Node maxNode;

    private static class Node {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        V = Integer.parseInt(bufferedReader.readLine());
        lists = new ArrayList[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int u = Integer.parseInt(stringTokenizer.nextToken());
            while (true) {
                int v = Integer.parseInt(stringTokenizer.nextToken());
                if (v == -1) break;

                int w = Integer.parseInt(stringTokenizer.nextToken());
                lists[u].add(new Node(v, w));
            }
        }

        maxNode = new Node(0, 0);
        dfs(1, 0);

        visited = new boolean[V + 1];
        dfs(maxNode.to, 0);

        System.out.println(maxNode.weight);
    }

    private static void dfs(int num, int len) {
        visited[num] = true;

        if (maxNode.weight < len) {
            maxNode = new Node(num, len);
        }

        for (Node node : lists[num]) {
            if (!visited[node.to]) {
                dfs(node.to, node.weight + len);
            }
        }
    }
}
