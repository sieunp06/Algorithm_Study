import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int islandNum = 1;
    private static int[][] map;
    private static boolean[][] visited;
    private static List<Edge> edges;
    private static int[] parent;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static class Edge implements Comparable<Edge> {
        int a, b, weight;
        Edge(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        changeNumberOfIsland();
        calIslandInfo();
        System.out.println(findMinBridge());
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        edges = new ArrayList<>();
    }

    private static void changeNumberOfIsland() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    changeNumber(i, j, islandNum++);
                }
            }
        }

        parent = new int[islandNum];
        for (int i = 1; i < islandNum; i++) {
            parent[i] = i;
        }
    }

    private static void changeNumber(int r, int c, int num) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {r, c});
        map[r][c] = num;
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] > 0) {
                    queue.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                    map[nr][nc] = num;
                }
            }
        }
    }

    private static void calIslandInfo() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (map[i][j] > 0) {
                    int startIsland = map[i][j];

                    for (int d = 0; d < 4; d++) {

                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        int length = 0;

                        while (isIn(nr, nc)) {
                            if (map[nr][nc] == 0) {
                                length++;
                                nr += dr[d];
                                nc += dc[d];
                            } else if (map[nr][nc] == startIsland) {
                                break;
                            } else {
                                if (length >= 2) {
                                    edges.add(new Edge(startIsland, map[nr][nc], length));
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private static int findMinBridge() {
        Collections.sort(edges);
        int weight = 0;
        int count = 0;
        for (Edge edge : edges) {
            if (union(edge.a, edge.b)) {
                weight += edge.weight;
                count++;
                if (count == islandNum - 2) break;
            }
        }
        if (count != islandNum - 2) return -1;
        return weight;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;
        parent[rootB] = rootA;
        return true;
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
