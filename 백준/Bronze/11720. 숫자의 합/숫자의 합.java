import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        String input = bf.readLine();

        int total = 0;
        for (char alpha : input.toCharArray()) {
            total += alpha - '0';
        }

        System.out.println(total);
    }
}
