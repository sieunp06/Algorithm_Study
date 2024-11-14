import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] distances = new int[N - 1];
        int[] prices = new int[N];
        
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N - 1; i++) {
            int distance = Integer.parseInt(stringTokenizer.nextToken());
            distances[i] = distance;
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int total = prices[0] * distances[0];
        int now = prices[0];
        int distanceIdx = 1;
        for (int i = 1; i < N - 1; i++) {
            if (now >= prices[i]) {
                now = prices[i];
            }
            total += now * distances[distanceIdx];
            distanceIdx++;
        }

        System.out.println(total);
    }
}