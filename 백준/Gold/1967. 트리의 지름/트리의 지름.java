import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static List<Node>[] list;
    private static boolean[] visited;
    private static Node maxNode;

    private static class Node {
        int son, value;

        Node (int son, int value) {
            this.son = son;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenize;

        n = Integer.parseInt(bufferedReader.readLine());
        list = new List[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            stringTokenize = new StringTokenizer(bufferedReader.readLine());
            int parent = Integer.parseInt(stringTokenize.nextToken()) - 1;
            int son = Integer.parseInt(stringTokenize.nextToken()) - 1;
            int value = Integer.parseInt(stringTokenize.nextToken());

            list[parent].add(new Node(son, value));
            list[son].add(new Node(parent, value));
        }

        maxNode = new Node(0, 0);
        dfs(0, 0);

        visited = new boolean[n];;
        dfs(maxNode.son, 0);

        System.out.println(maxNode.value);
    }

    private static void dfs(int now, int len) {
        visited[now] = true;

        if (maxNode.value < len) {
            maxNode = new Node(now, len);
        }

        for (Node node : list[now]) {
            if (!visited[node.son]) {
                dfs(node.son, len + node.value);
            }
        }

    }
}
