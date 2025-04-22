import java.io.*;
import java.util.*;

public class Main {
    static long A, B, C;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        stringBuilder.append(power(A, B)).append("\n");
        System.out.print(stringBuilder);
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        A = Long.parseLong(stringTokenizer.nextToken());
        B = Long.parseLong(stringTokenizer.nextToken());
        C = Long.parseLong(stringTokenizer.nextToken());
    }

    static long power(long base, long exp) {
        if (exp == 0) return 1;
        long half = power(base, exp / 2);
        long result = (half * half) % C;
        if (exp % 2 == 1) {
            result = (result * base) % C;
        }
        return result;
    }
}
