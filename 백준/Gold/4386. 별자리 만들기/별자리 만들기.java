import java.io.*;
import java.util.*;

public class Main {
    static class Star {
        double x, y;

        Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to;
        double cost;

        Edge(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }
    }

    static int N;
    static int[] parent;
    static List<Star> stars = new ArrayList<>();
    static List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        parent = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars.add(new Star(x, y));
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Star a = stars.get(i);
                Star b = stars.get(j);

                double dx = a.x - b.x;
                double dy = a.y - b.y;
                double dist = Math.sqrt(dx * dx + dy * dy);

                edges.add(new Edge(i, j, dist));
            }
        }

        Collections.sort(edges);

        double answer = 0.0;
        int count = 0;

        for (Edge e : edges) {
            if (find(e.from) != find(e.to)) {
                union(e.from, e.to);
                answer += e.cost;
                count++;

                if (count == N - 1) break;
            }
        }

        System.out.println(answer);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }
}
