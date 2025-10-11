import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N;
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(process());
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        generatePrimeNumbers();
    }

    private static void generatePrimeNumbers() {
        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i * i <= N; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        for (int i = 2; i <= N; i++) {
            if (!isPrime[i]) primes.add(i);
        }
    }

    private static int process() {
        int count = 0;
        int start = 0; int end = 0;
        int total = 0;

        while (true) {
            if (total >= N) {
                if (total == N) count++;
                total -= primes.get(start++);
            } else {
                if (end == primes.size()) break;
                total += primes.get(end++);
            }
        }
        return count;
    }
}
