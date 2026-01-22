import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[] temp = new int[N + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= N; i++) {
            temp[i] = Integer.parseInt(stringTokenizer.nextToken()) + temp[i - 1];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i + K - 1 <= N; i++) {
            int sum = temp[i + K - 1] - temp[i - 1];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
