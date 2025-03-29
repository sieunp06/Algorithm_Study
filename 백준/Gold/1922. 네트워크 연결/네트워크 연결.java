import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static PriorityQueue<Computer> computers;
    static int[] parents;

    static class Computer implements Comparable<Computer> {
        int from, to, weight;

        Computer(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Computer c) {
            return weight - c.weight;
        }
    }

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(kruskal());
    }

    static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        M = Integer.parseInt(bufferedReader.readLine());

        computers = new PriorityQueue<>();
        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());

            computers.add(new Computer(from, to, weight));
        }
    }

    static long kruskal() {
        long totalWeight = 0;
        int count = 0;

        while (!computers.isEmpty()) {
            Computer computer = computers.poll();

            if (union(computer.from, computer.to)) {
                totalWeight += computer.weight;
                if (++count == N - 1) break;
            }
        }

        return totalWeight;
    }

    static int find(int x) {
        if (x != parents[x])
            parents[x] = find(parents[x]);
        return parents[x];
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;

        parents[rootB] = rootA;
        return true;
    }
}
