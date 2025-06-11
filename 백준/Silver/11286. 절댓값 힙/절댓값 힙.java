import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }
                return Integer.compare(Math.abs(o1), Math.abs(o2));
            }
        });

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(bufferedReader.readLine());

            if (target == 0) {
                stringBuilder.append(priorityQueue.isEmpty() ? 0 : priorityQueue.poll()).append("\n");
                continue;
            }
            priorityQueue.add(target);
        }
        System.out.println(stringBuilder);
    }
}
