import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            int N = Integer.parseInt(line);
            int[] prices = new int[N];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            System.out.println(getLISLength(prices));
        }
    }

    private static int getLISLength(int[] arr) {
        List<Integer> lis = new ArrayList<>();
        for (int num : arr) {
            int idx = Collections.binarySearch(lis, num);
            if (idx < 0) idx = -idx - 1;

            if (idx == lis.size()) lis.add(num);
            else lis.set(idx, num);
        }
        return lis.size();
    }
}
