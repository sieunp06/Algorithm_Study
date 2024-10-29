import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long total = 0;
        long count = 0;
        for (int i = 1; ; i++) {
            if (total > S) {
                break;
            }
            total += i;
            count++;
        }
        System.out.println(count - 1);
    }
}