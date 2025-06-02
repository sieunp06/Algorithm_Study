import java.io.*;
import java.util.*;

public class Main {
    static int N, T, P;
    static int[] numbers = new int[6];

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(calNumOfShirts());
        System.out.println(N / P + " " + N % P);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 6; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        T = Integer.parseInt(stringTokenizer.nextToken());
        P = Integer.parseInt(stringTokenizer.nextToken());
    }

    private static int calNumOfShirts() {
        int total = 0;
        for (int num : numbers) {
            total += num / T;
            if (num % T != 0) {
                total += 1;
            }
        }
        return total;
    }
}
