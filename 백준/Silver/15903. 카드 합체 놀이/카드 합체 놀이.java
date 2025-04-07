import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static PriorityQueue<Long> cards;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        calculate();
        System.out.println(sum());
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        cards = new PriorityQueue<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            cards.add(Long.parseLong(stringTokenizer.nextToken()));
        }
    }

    static void calculate() {
        for (int i = 0; i < m; i++) {
            long num1 = cards.poll();
            long num2 = cards.poll();

            for (int j = 0; j < 2; j++) {
                cards.add(num1 + num2);
            }
        }
    }

    static long sum() {
        long total = 0;
        while (!cards.isEmpty()) {
            total += cards.poll();
        }
        return total;
    }
}
