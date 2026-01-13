import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(bufferedReader.readLine());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            PriorityQueue<Long> list = new PriorityQueue<>();
            for (int j = 0; j < K; j++) {
                list.add(Long.parseLong(stringTokenizer.nextToken()));
            }

            long answer = 0;
            while (list.size() != 1) {
                long cost = list.poll() + list.poll();
                list.add(cost);
                answer += cost;
            }
            stringBuilder.append(answer).append("\n");
        }
        System.out.print(stringBuilder);
    }
}
