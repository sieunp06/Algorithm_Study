import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;
        int N = Integer.parseInt(bf.readLine());
        int[] minutes = new int[N + 1];

        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            minutes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(minutes);

        for (int i = 0; i < N; i++) {
            minutes[i + 1] += minutes[i];
        }

        for (int i = 1; i <= N; i++)
            answer += minutes[i];

        System.out.println(answer);
    }
}