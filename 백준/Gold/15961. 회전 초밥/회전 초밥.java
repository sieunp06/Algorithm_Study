import java.io.*;
import java.util.*;

public class Main {
    static int N, d, k, c;
    static int[] sushi;
    static Map<Integer, Integer> map = new HashMap<>();
    static int answer = 0;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.println(answer);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        d = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());

        sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(bufferedReader.readLine());
        }
    }

    static void solve() {
        for (int i = 0; i < k; i++) {
            map.put(sushi[i], map.getOrDefault(sushi[i], 0) + 1);
        }

        answer = map.containsKey(c) ? map.size() : map.size() + 1;

        for (int i = 1; i < N; i++) {
            int remove = sushi[(i - 1) % N];
            map.put(remove, map.get(remove) - 1);
            if (map.get(remove) == 0) map.remove(remove);

            int add = sushi[(i + k - 1) % N];
            map.put(add, map.getOrDefault(add, 0) + 1);

            int current = map.containsKey(c) ? map.size() : map.size() + 1;
            answer = Math.max(answer, current);
        }
    }
}
