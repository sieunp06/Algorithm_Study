import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> prices = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            prices.add(Integer.parseInt(bufferedReader.readLine()));
        }

        int total = 0;
        while (prices.size() >= 3) {
            int p1 = prices.poll();
            int p2 = prices.poll();
            prices.remove();

            total += p1 + p2;
        }

        while (!prices.isEmpty()) {
            total += prices.poll();
        }

        System.out.println(total);
    }
}