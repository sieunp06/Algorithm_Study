import java.io.*;
import java.util.*;

public class Main {
    private static HashSet<Integer>[] sets;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int Q = Integer.parseInt(stringTokenizer.nextToken());

        sets = new HashSet[N + 1];

        for (int i = 1; i <= N; i++) {
            sets[i] = new HashSet<>();
        }

        for (int i = 1; i <= N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            for (int j = 0; j < k; j++) {
                sets[i].add(Integer.parseInt(stringTokenizer.nextToken()));
            }
        }

        for (int i = 0; i < Q; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int command = Integer.parseInt(stringTokenizer.nextToken());

            int a = Integer.parseInt(stringTokenizer.nextToken());
            if (command == 1) {
                int b = Integer.parseInt(stringTokenizer.nextToken());
                merge(a, b);
            } else {
                stringBuilder.append(sets[a].size()).append("\n");
            }
        }

        System.out.println(stringBuilder);
    }

    private static void merge(int a, int b) {
        if (sets[b].isEmpty()) return;

        if (sets[a].size() < sets[b].size()) {
            HashSet<Integer> temp = sets[a];
            sets[a] = sets[b];
            sets[b] = temp;
        }

        sets[a].addAll(sets[b]);
        sets[b].clear();
    }
}
