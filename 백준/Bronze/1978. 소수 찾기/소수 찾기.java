import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] numbers;
    static boolean[] isComposite;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(getPrimeCount());
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        numbers = new int[N];

        int max = Integer.MIN_VALUE;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
            max = Math.max(max, numbers[i]);
        }

        isComposite = new boolean[max + 1];
        sieve(max);
    }

    private static void sieve(int max) {
        isComposite[0] = true;
        isComposite[1] = true;
        for (int i = 2; i * i <= max; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isComposite[j] = true;
                }
            }
        }
    }

    private static int getPrimeCount() {
        int total = 0;
        for (int number : numbers) {
            if (!isComposite[number]) {
                total++;
            }
        }
        return total;
    }
}
