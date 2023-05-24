import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        long[] numbers = new long[10000001];

        for (int i = 2; i < numbers.length; i++) {
            numbers[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(numbers.length); i++) {
            if (numbers[i] == 0) continue;
            for (int j = i + i; j < numbers.length; j += i) {
                numbers[j] = 0;
            }
        }

        int count = 0;
        for (int i = 2; i < 10000001; i++) {
            if (numbers[i] != 0) {
                long temp = numbers[i];
                while ((double)numbers[i] <= (double)max / (double)temp) {
                    if ((double)numbers[i] >= (double)min / (double)temp) {
                        count++;
                    }
                    temp = temp * numbers[i];
                }
            }
        }
        System.out.println(count);
    }
}