import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] x, y;
    static double E;

    static List<Island> edges;
    static int[] parents;

    static class Island {
        int from, to;
        long weight;

        Island(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));;
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int tc = 1; tc <= T; tc++) {
            init();
            stringBuilder.append("#").append(tc).append(" ").append(calculate()).append("\n");
        }

        System.out.println(stringBuilder);
    }

    static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());    // 섬의 개수
        x = new int[N];
        y = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            y[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        E = Double.parseDouble(bufferedReader.readLine());

        edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                long dx = x[i] - x[j];
                long dy = y[i] - y[j];

                edges.add(new Island(i, j, dx * dx + dy * dy));
            }
        }

        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    static long calculate() {
        edges.sort(Comparator.comparingLong(e -> e.weight));

        int count = 0;
        long totalCost = 0;

        for (Island i : edges) {
            if (union(i.from, i.to)) {
                totalCost += i.weight;
                count++;
                if (count == N - 1) {
                    break;
                }
            }
        }
        return Math.round(totalCost * E);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;
        parents[rootB] = rootA;
        return true;
    }

    static int find(int a) {
        if (parents[a] != a)
            parents[a] = find(parents[a]);
        return parents[a];
    }
}
