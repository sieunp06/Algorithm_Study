import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N, M;
    static int[][] planet, answer;

    public static void main(String[] args) throws IOException {
        init();
        rank();
        int result = find();
        stringBuilder.append(result);
        System.out.println(stringBuilder);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        planet = new int[N][M];
        answer = new int[N][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                planet[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    static void rank() {
        for (int i = 0; i < N; i++) {
            int[] copy = planet[i].clone();
            Map<Integer, Integer> map = new HashMap<>();

            Arrays.sort(copy);

            int rank = 1;
            for (int num : copy) {
                if (!map.containsKey(num)) {
                    map.put(num, rank++);
                }
            }

            for (int j = 0; j < M; j++) {
                answer[i][j] = map.get(planet[i][j]);
            }
        }
    }

    static int find() {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < M; j++) {
                sb.append(answer[i][j]).append(",");
            }
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int val : map.values()) {
            count += val * (val - 1) / 2;
        }

        return count;
    }
}
