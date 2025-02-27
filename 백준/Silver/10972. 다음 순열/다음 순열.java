import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] number;
    private static boolean flag = true;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        nextPermutation();
        if (flag) {
            print();
        } else {
            System.out.println(-1);
        }
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        number = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    private static void nextPermutation() {
        int idx = N - 1;
        while (idx > 0 && number[idx - 1] > number[idx]) {
            idx--;
        }

        if (idx == 0) {
            flag = false;
            return;
        }

        int big_idx = N - 1;
        while (big_idx > idx && number[idx - 1] > number[big_idx]) {
            big_idx--;
        }

        int temp = number[idx - 1];
        number[idx - 1] = number[big_idx];
        number[big_idx] = temp;

        Arrays.sort(number, idx, N);
    }

    private static void print() {
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i] + " ");
        }
    }
}
