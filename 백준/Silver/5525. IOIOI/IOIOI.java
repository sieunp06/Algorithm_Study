import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        String S = bufferedReader.readLine();

        int answer = 0;
        int count = 0;
        int idx = 0;

        while (idx < M - 1) {
            if (S.charAt(idx) == 'I' && S.charAt(idx + 1) == 'O') {
                count++;
                idx += 2;
                continue;
            }
            if (S.charAt(idx) == 'I') {
                if (count >= N) {
                    answer += count - N + 1;
                }
            } else {
                if (count >= N) {
                    answer += count - N;
                }
            }
            count = 0;
            idx++;
        }

        if (count >= N) {
            if (idx < M && S.charAt(idx) == 'I') {
                answer += count - N + 1;
            } else {
                answer += count - N;
            }
        }
        System.out.println(answer);
    }
}