import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int answer = 1;
        int startIdx = 1;
        int endIdx = 1;
        int sum = 1;

        while (endIdx != N) {
            if (sum == N) {
                answer++;
                endIdx++;
                sum += endIdx;
            } else if (sum > N) {
                sum -= startIdx;
                startIdx++;
            } else {
                endIdx++;
                sum += endIdx;
            }
        }

        System.out.println(answer);
    }
}