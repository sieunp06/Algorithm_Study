import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int k;
    static PriorityQueue<Integer> minHeap;
    static PriorityQueue<Integer> maxHeap;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            init();
            process();
            printResult();
        }
        System.out.print(stringBuilder);
    }

    static void init() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        map = new HashMap<>();
    }

    static void process() throws IOException {
        k = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < k; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String cmd = stringTokenizer.nextToken();
            int num = Integer.parseInt(stringTokenizer.nextToken());

            if (cmd.equals("I")) {
                minHeap.offer(num);
                maxHeap.offer(num);
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                if (num == 1) { // delete max
                    remove(maxHeap);
                } else { // delete min
                    remove(minHeap);
                }
            }
        }
    }

    static void remove(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int now = heap.poll();
            int count = map.getOrDefault(now, 0);
            if (count == 0) continue;
            if (count == 1) map.remove(now);
            else map.put(now, count - 1);
            break;
        }
    }

    static void printResult() {
        cleanHeap(maxHeap);
        cleanHeap(minHeap);

        if (map.isEmpty()) {
            stringBuilder.append("EMPTY\n");
        } else {
            stringBuilder.append(maxHeap.peek()).append(" ").append(minHeap.peek()).append("\n");
        }
    }

    static void cleanHeap(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int now = heap.peek();
            if (map.getOrDefault(now, 0) == 0) {
                heap.poll();
            } else break;
        }
    }
}
