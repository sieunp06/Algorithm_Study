import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static PriorityQueue<Jewel> jewels;
    static PriorityQueue<Integer> bags;

    static class Jewel {
        int M, V;

        Jewel(int M, int V) {
            this.M = M;
            this.V = V;
        }
    }

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(steal());
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        jewels = new PriorityQueue<>((o1, o2) -> {
            if (o1.M == o2.M) {
                return o2.V - o1.V;
            }
            return o1.M - o2.M;
        });
        bags = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int M = Integer.parseInt(stringTokenizer.nextToken());
            int V = Integer.parseInt(stringTokenizer.nextToken());

            jewels.add(new Jewel(M, V));
        }

        for (int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(bufferedReader.readLine()));
        }
    }

    static long steal() {
        long total = 0;
        PriorityQueue<Integer> valueQueue = new PriorityQueue<>(Collections.reverseOrder());

        while (!bags.isEmpty()) {
            int now = bags.poll();

            while (!jewels.isEmpty() && jewels.peek().M <= now) {
                valueQueue.add(jewels.poll().V);
            }

            if (!valueQueue.isEmpty()) {
                total += valueQueue.poll();
            }
        }

        return total;
    }
}
