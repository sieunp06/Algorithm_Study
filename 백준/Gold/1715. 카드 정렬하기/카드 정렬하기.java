import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Integer> cards = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
             cards.add(Integer.parseInt(bufferedReader.readLine()));
        }

        int total = 0;
        while (cards.size() > 1) {
            int num1 = cards.poll();
            int num2 = cards.poll();
            total += num1 + num2;
            cards.add(num1 + num2);
    }

        System.out.println(total);
    }
}