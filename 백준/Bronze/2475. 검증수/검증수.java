import java.io.*;
import java.util.*;

public class Main {
    static final int LEN = 5;
    static int[] numbers = new int[LEN];

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sum());
    }

    static void init() throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < LEN; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
    }

    static int sum() {
        int total = 0;
        for (int num : numbers) {
            total += Math.pow(num, 2);
        }
        return total % 10;
    }
}
