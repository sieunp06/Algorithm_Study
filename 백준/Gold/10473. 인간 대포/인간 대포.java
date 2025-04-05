import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        double x, y;
        Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int to;
        double cost;
        Edge(int to, double cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }
    }

    static int n;
    static Node[] positions;
    static List<Edge>[] graph;
    static double[] dist;

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        buildGraph();
        dijkstra(0);
        System.out.println(dist[1]);
    }

    static void init() throws IOException {
        positions = new Node[502]; 
        st = new StringTokenizer(br.readLine());
        double sx = Double.parseDouble(st.nextToken());
        double sy = Double.parseDouble(st.nextToken());
        positions[0] = new Node(sx, sy);

        st = new StringTokenizer(br.readLine());
        double tx = Double.parseDouble(st.nextToken());
        double ty = Double.parseDouble(st.nextToken());
        positions[1] = new Node(tx, ty);

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            positions[i + 2] = new Node(x, y);
        }
    }

    static void buildGraph() {
        int total = n + 2;
        graph = new ArrayList[total];
        for (int i = 0; i < total; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < total; i++) {
            for (int j = 0; j < total; j++) {
                if (i == j) continue;
                double dist = getDistance(positions[i], positions[j]);
                double time;

                if (i >= 2) {
                    double walkTime = dist / 5.0;
                    double jumpTime = 2.0 + Math.abs(dist - 50) / 5.0;
                    time = Math.min(walkTime, jumpTime);
                } else {
                    time = dist / 5.0;
                }

                graph[i].add(new Edge(j, time));
            }
        }
    }

    static void dijkstra(int start) {
        int total = n + 2;
        dist = new double[total];
        Arrays.fill(dist, Double.MAX_VALUE);
        dist[start] = 0.0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0.0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int now = cur.to;

            if (dist[now] < cur.cost) continue;

            for (Edge next : graph[now]) {
                double newCost = dist[now] + next.cost;
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.offer(new Edge(next.to, newCost));
                }
            }
        }
    }

    static double getDistance(Node a, Node b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
