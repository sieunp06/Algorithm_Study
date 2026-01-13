import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int K = Integer.parseInt(stringTokenizer.nextToken());

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
            for (int j = 0; j < N; j++) {
                priorityQueue.add(Long.parseLong(stringTokenizer.nextToken()));
            }

            int dummyLeaf = (priorityQueue.size() - 1) % (K - 1);
            if (dummyLeaf != 0) {
                for (int j = 0; j < (K - 1) - dummyLeaf; j++) {
                    priorityQueue.add(0L);
                }
            }

            long answer = 0;
            while (priorityQueue.size() != 1) {
                long sum = 0;
                for (int j = 0; j < K; j++) {
                    sum += priorityQueue.poll();
                }
                answer += sum;
                priorityQueue.add(sum);
            }

            stringBuilder.append(answer).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
