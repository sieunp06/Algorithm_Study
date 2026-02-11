import java.io.*;
import java.util.*;

public class Main {
    private static class Jewel {
        int weight;
        int value;
        Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        Jewel[] jewels = new Jewel[N];
        int[] bags = new int[K];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int M = Integer.parseInt(stringTokenizer.nextToken());
            int V = Integer.parseInt(stringTokenizer.nextToken());
            jewels[i] = new Jewel(M, V);
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(jewels, Comparator.comparingInt(a -> a.weight));
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long answer = 0;
        int j = 0;
        for (int i = 0; i < K; i++) {
            while (j < N && jewels[j].weight <= bags[i]) {
                pq.offer(jewels[j].value);
                j++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}
