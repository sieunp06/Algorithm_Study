import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] parent;
    private static List<Node> list;

    private static class Node implements Comparable<Node> {
        int A, B, C;
        Node(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }

        @Override
        public int compareTo(Node o) {
            return this.C - o.C;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        list = new ArrayList<>();
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());
            int C = Integer.parseInt(stringTokenizer.nextToken());

            list.add(new Node(A, B, C));
        }

        Collections.sort(list);

        int weight = 0;
        int maxWeight = 0;
        int count = 0;
        for (Node n : list) {
            if (union(n.A, n.B)) {
                weight += n.C;
                count++;
                maxWeight = Math.max(maxWeight, n.C);
                if (count == N - 1) break;
            }
        }

        System.out.println(weight - maxWeight);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;
        parent[b] = a;
        return true;
    }
}
