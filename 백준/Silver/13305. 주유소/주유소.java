import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] len = new int[N - 1];
        int[] price = new int[N - 1];

        StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
        StringTokenizer stringTokenizer2 = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N - 1; i++) {
            len[i] = Integer.parseInt(stringTokenizer1.nextToken());
            price[i] = Integer.parseInt(stringTokenizer2.nextToken());
        }

        int cheapestPrice = price[0];
        int answer = len[0] * price[0];
        for (int i = 1; i < N - 1; i++) {
            cheapestPrice = Math.min(cheapestPrice, price[i]);
            answer += len[i] * cheapestPrice;
        }
        System.out.println(answer);
    }
}
