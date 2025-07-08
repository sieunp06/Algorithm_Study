import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N, answer;
    static int[] fruits;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.println(answer);
    }

    static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        answer = Integer.MIN_VALUE;
        fruits = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    static void solve() {
        int left = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (int right = 0; right < N; right++) {
            count.put(fruits[right], count.getOrDefault(fruits[right], 0) + 1);

            while (count.size() > 2) {
                int fruit = fruits[left];
                count.put(fruit, count.get(fruit) - 1);
                if (count.get(fruit) == 0) {
                    count.remove(fruit);
                }
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }
    }
}
