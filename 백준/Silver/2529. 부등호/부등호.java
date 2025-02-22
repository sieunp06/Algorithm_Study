import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int k;
    private static String[] signs;
    private static boolean[] isSelected;
    private static int[] numbers;

    private static long target;
    private static long[] answer;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringBuilder now;
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        permutation(0);
        System.out.println(answer[1]);
        if (String.valueOf(answer[0]).length() < k + 1) {
            System.out.println("0" + answer[0]);
        } else {
            System.out.println(answer[0]);
        }
    }

    private static void init() throws IOException {
        k = Integer.parseInt(bufferedReader.readLine());
        signs = new String[k];
        numbers = new int[k + 1];
        isSelected = new boolean[10];
        answer = new long[] {Long.MAX_VALUE, Long.MIN_VALUE};

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < k; i++) {
            signs[i] = stringTokenizer.nextToken();
        }
    }

    private static void permutation(int depth) {
        if (depth == k + 1) {
            if (check()) {
                now = new StringBuilder();
                for (int i = 0; i < k + 1; i++) {
                    now.append(numbers[i]);
                }
                target = Long.parseLong(now.toString());
                if (answer[0] > target) {
                    answer[0] = target;
                }
                if (answer[1] < target) {
                    answer[1] = target;
                }
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (isSelected[i]) {
                continue;
            }
            numbers[depth] = i;
            isSelected[i] = true;
            permutation(depth + 1);
            isSelected[i] = false;
        }
    }

    private static boolean check() {
        for (int i = 1; i <= k; i++) {
            String sign = signs[i - 1];

            if (sign.equals(">")) {
                if (numbers[i - 1] <= numbers[i]) {
                    return false;
                }
            }
            if (sign.equals("<")) {
                if (numbers[i - 1] >= numbers[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}