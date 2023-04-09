import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (M - 45 < 0) {
            H -= 1;
            M += 15;
            if (H < 0) {
                H = 23;
            }
        }
        else {
            M -= 45;
        }

        System.out.println(H + " " + M);
    }
}