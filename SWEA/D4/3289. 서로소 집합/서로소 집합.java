import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static int n, m;
    private static int[] parent;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            stringBuilder.append("#").append(testCase).append(" ");
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            n = Integer.parseInt(stringTokenizer.nextToken());
            m = Integer.parseInt(stringTokenizer.nextToken());

            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < m; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int command = Integer.parseInt(stringTokenizer.nextToken());
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());

                if (command == 0) { // 합집합
                    union(a, b);
                }
                if (command == 1) { // 두 원소가 같은 집합에 포함되어 있는지 확인
                    if (find(a) == find(b)) {
                        stringBuilder.append(1);
                    } else {
                        stringBuilder.append(0);
                    }
                }
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
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
