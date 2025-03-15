import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, K;
    private static long[] numbers, tree;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        numbers = new long[N + 1];
        tree = new long[getTreeSize()];

        for (int i = 0; i < N; i++) {
            numbers[i] = Long.parseLong(bufferedReader.readLine());
        }
        makeTree(0, N - 1, 1);

        for (int i = 0; i < M + K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int command = Integer.parseInt(stringTokenizer.nextToken());
            if (command == 1) {
                int index = Integer.parseInt(stringTokenizer.nextToken()) - 1;
                long num = Long.parseLong(stringTokenizer.nextToken());

                long diff = num - numbers[index];
                numbers[index] = num;
                update(0, N - 1, 1, index, diff);
            } else {
                int left = Integer.parseInt(stringTokenizer.nextToken()) - 1;
                int right = Integer.parseInt(stringTokenizer.nextToken()) - 1;

                stringBuilder.append(sum(0, N - 1, 1, left, right)).append("\n");
            }
        }
        System.out.print(stringBuilder);
    }

    private static int getTreeSize() {
        int height = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        return (int) Math.pow(2, height);
    }

    private static long makeTree(int start, int end, int node) {
        if (start == end) {
            return tree[node] = numbers[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = makeTree(start, mid, node * 2) + makeTree(mid + 1, end, node * 2 + 1);
    }

    private static void update(int start, int end, int node, int index, long diff) {
        if (index < start || end < index) {
            return;
        }
        tree[node] += diff;
        if (start != end) {
            int mid = (start + end) / 2;
            update(start, mid, node * 2, index, diff);
            update(mid + 1, end, node * 2 + 1, index, diff);
        }
    }

    private static long sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }
}
