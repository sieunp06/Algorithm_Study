import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int v = Integer.parseInt(bufferedReader.readLine());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (v == Integer.parseInt(stringTokenizer.nextToken())) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
