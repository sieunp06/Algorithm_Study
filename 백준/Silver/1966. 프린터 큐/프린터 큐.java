import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(stringTokenizer.nextToken());
                queue.offer(new int[]{i, priority});
                priorityQueue.offer(priority);
            }

            int count = 0;
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int idx = current[0];
                int pri = current[1];

                if (pri == priorityQueue.peek()) {
                    count++;
                    priorityQueue.poll();

                    if (idx == M) {
                        stringBuilder.append(count).append("\n");
                        break;
                    }
                } else {
                    queue.offer(current);
                }
            }
        }

        System.out.print(stringBuilder);
    }
}
