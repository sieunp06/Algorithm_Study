import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            String[] target = bufferedReader.readLine().split(" ");
            for (String t : target) {
                answer.append(new StringBuilder(t).reverse()).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}