import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        int N = Integer.parseInt(bf.readLine());

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num != 1) {
                boolean isSosoo = true;
                for (int j = 2; j < num; j++) {
                    if (num % j == 0)
                        isSosoo = false;
                }
                if (isSosoo)
                    answer++;
            }
        }

        System.out.println(answer);
    }
}