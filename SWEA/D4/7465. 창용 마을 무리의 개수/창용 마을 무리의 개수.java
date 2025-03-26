import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    private static int[] parent;
    private static int N, M;

    private static Set<Integer> set;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            init();
            for (int i = 1; i <= N; i++) {
                parent[i] = find(parent[i]);
                set.add(parent[i]);
            }

            stringBuilder.append("#").append(testCase).append(" ").append(set.size()).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        parent = new int[N + 1];
        set = new HashSet<>();

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            union(a, b);
        }
    }

    private static void union(int num1, int num2) {
        int rootNum1 = find(num1);
        int rootNum2 = find(num2);

        if (rootNum1 > rootNum2) {
            parent[rootNum2] = rootNum1;
        } else {
            parent[rootNum1] = rootNum2;
        }
    }

    private static int find(int num) {
        if (parent[num] == num) return num;
        return find(parent[num]);
    }
}
