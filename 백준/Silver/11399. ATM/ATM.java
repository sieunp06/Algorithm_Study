import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[] times = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(times);

        int sum = 0;
        int total = 0;
        for (int i = 0; i < N; i++) {
            sum += times[i];
            total += sum;
        }

        System.out.println(total);
    }
}
