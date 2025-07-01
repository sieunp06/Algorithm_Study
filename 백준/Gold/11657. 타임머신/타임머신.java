import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int N, M;
    private static List<Bus> list = new ArrayList<>();
    private static long[] distance;
    private static final int INF = Integer.MAX_VALUE;

    private static class Bus {
        int from, to, time;
        Bus(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        if (bellmanFord()) {    // 음수 사이클 존재
            System.out.println(-1);
        } else {
            for (int i = 1; i <= N; i++) {
                if (i == 1) continue;
                stringBuilder.append(distance[i] == INF ? -1 : distance[i]).append("\n");
            }
            System.out.print(stringBuilder);
        }
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int time = Integer.parseInt(stringTokenizer.nextToken());

            list.add(new Bus(from, to, time));
        }

        distance = new long[N + 1];
        Arrays.fill(distance, INF);
        distance[1] = 0;
    }

    private static boolean bellmanFord() {
        for (int i = 1; i < N; i++) {
            for (Bus bus : list) {
                if (distance[bus.from] != INF && distance[bus.to] > distance[bus.from] + bus.time) {
                    distance[bus.to] = distance[bus.from] + bus.time;
                }
            }
        }

        for (Bus bus : list) {
            if (distance[bus.from] != INF && distance[bus.to] > distance[bus.from] + bus.time) {
                return true;
            }
        }
        return false;
    }
}
