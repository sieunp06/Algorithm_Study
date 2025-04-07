import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static PriorityQueue<Integer> gift;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bufferedReader.readLine());
        gift = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());

            if (a == 0) {
                deliver();
            }

            for (int j = 0; j < a; j++) {
                gift.add(Integer.parseInt(stringTokenizer.nextToken()));
            }
        }
    }

    static void deliver() {
        System.out.println(gift.isEmpty() ? -1 : gift.poll());
    }
}
