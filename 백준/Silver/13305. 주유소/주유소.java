import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        long[] len = new long[N - 1];
        long[] price = new long[N - 1];

        StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
        StringTokenizer stringTokenizer2 = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N - 1; i++) {
            len[i] = Long.parseLong(stringTokenizer1.nextToken());
            price[i] = Long.parseLong(stringTokenizer2.nextToken());
        }

        long cheapestPrice = price[0];
        long answer = len[0] * price[0];
        for (int i = 1; i < N - 1; i++) {
            cheapestPrice = Math.min(cheapestPrice, price[i]);
            answer += len[i] * cheapestPrice;
        }
        System.out.println(answer);
    }
}
