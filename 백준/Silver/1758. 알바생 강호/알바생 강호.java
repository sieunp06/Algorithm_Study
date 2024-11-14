import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(numbers);

        long total = 0;
        for (int i = N - 1; i >= 0; i--) {
            int tip = numbers[i] - N + i + 1;
            if (tip > 0) {
                total += tip;
            }
        }

        System.out.println(total);
    }
}