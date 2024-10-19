import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                continue;
            }
            boolean flag = true;
            for (int j = 2; j < num; j++) {
                if (num % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
