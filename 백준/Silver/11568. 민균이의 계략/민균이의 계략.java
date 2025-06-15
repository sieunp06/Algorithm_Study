import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int N;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(find());
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        numbers = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static int find() {
        List<Integer> lis = new ArrayList<>();
        for (int num : numbers) {
            int idx = Collections.binarySearch(lis, num);
            if (idx < 0) idx = -idx - 1;
            if (idx == lis.size()) lis.add(num);
            else lis.set(idx, num);
        }
        return lis.size();
    }
}
