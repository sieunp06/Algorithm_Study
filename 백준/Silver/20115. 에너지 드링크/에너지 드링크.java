import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        double max = Double.MIN_VALUE;
        int maxIdx = -1;
        double[] numbers = new double[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            numbers[i] = number;
            if (max < number) {
                max = number;
                maxIdx = i;
            }
        }

        for (int i = 0; i < N; i++) {
            if (i != maxIdx) {
                max += numbers[i] / 2;
            }
        }

        if ((int) max == max) {
            System.out.println((int) max);
            return;
        }
        System.out.println(max);
    }
}