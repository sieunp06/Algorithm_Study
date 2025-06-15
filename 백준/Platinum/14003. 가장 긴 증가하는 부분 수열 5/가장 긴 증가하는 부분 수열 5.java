import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int N;
    private static int[] numbers, position;
    private static List<Integer> list;

    public static void main(String[] args) throws IOException {
        init();
        find();
        stringBuilder.append(list.size()).append("\n");
        buildLIS(list.size());
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        numbers = new int[N];
        position = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void find() {
        list = new ArrayList<>();

        list.add(numbers[0]);
        position[0] = 0;

        for (int i = 1; i < N; i++) {
            int num = numbers[i];

            if (num > list.get(list.size() - 1)) {
                list.add(num);
                position[i] = list.size() - 1;
            } else {
                int idx = Collections.binarySearch(list, num);
                if (idx < 0) {
                    idx = -idx - 1;
                }
                list.set(idx, num);
                position[i] = idx;
            }
        }
    }

    private static void buildLIS(int length) {
        int idx = length - 1;
        int[] result = new int[length];

        for (int i = N - 1; i >= 0; i--) {
            if (position[i] == idx) {
                result[idx] = numbers[i];
                idx--;
            }
        }

        for (int val : result) {
            stringBuilder.append(val).append(" ");
        }
    }
}
