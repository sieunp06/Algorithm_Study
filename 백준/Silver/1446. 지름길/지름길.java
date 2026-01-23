import java.io.*;
import java.util.*;

public class Main {
    private static int N, D;
    private static List<Node>[] lists;

    private static class Node {
        int start, end, weight;
        Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        D = Integer.parseInt(stringTokenizer.nextToken());

        lists = new List[10_001];

        for (int i = 0; i <= 10000; i++) {
            lists[i] = new ArrayList();
        }

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());

            if (end <= D) {
                lists[start].add(new Node(start, end, weight));
            }
        }

        int[] dp = new int[D + 1];
        for (int i = 0; i <= D; i++) {
            dp[i] = i;
        }

        for (int i = 0; i <= D; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }

            for (Node node : lists[i]) {
                dp[node.end] = Math.min(dp[node.end], dp[i] + node.weight);
            }
        }

        System.out.println(dp[D]);
    }
}
