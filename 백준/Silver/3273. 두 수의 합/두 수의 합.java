import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer input = new StringTokenizer(bufferedReader.readLine());
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(input.nextToken());
        }
        int x = Integer.parseInt(bufferedReader.readLine());
        Arrays.sort(inputs);

        int start = 0; int end = n - 1;
        int answer = 0;
        while (start < end) {
            int total = inputs[start] + inputs[end];
            if (total == x) {
                answer++;
                start++; end--;
            } else if (total < x) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(answer);
    }
}
