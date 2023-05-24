import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N + 1];

        for (int i = 2; i <= N; i++)
            numbers[i] = i;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (numbers[i] == 0)
                continue;
            for (int j = i + i; j <= N; j += i) {
                numbers[j] = 0;
            }
        }

        for (int i = M; i <= N; i++) {
            if (numbers[i] != 0)
                System.out.println(numbers[i]);
        }
    }
}