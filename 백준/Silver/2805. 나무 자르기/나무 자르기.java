import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int N, M, max;
    private static int[] tree;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(find());
    }

    private static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        tree = new int[N];
        max = Integer.MIN_VALUE;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(stringTokenizer.nextToken());
            max = Math.max(max, tree[i]);
        }
        Arrays.sort(tree);
    }

    private static int find() {
        int left = 0;
        int right = max;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                result = mid;     
                left = mid + 1;   
            } else {
                right = mid - 1; 
            }
        }

        return result;
    }


    private static boolean check(int len) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (tree[i] > len) {
                sum += (tree[i] - len);
            }
        }
        return sum >= M;
    }

}