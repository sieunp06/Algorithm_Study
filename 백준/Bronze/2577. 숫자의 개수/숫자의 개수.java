import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int[] count = new int[10];

        int total = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < 2; i++) {
            total *= Integer.parseInt(bufferedReader.readLine());
        }

        for (char number : String.valueOf(total).toCharArray()) {
            count[number - '0']++;
        }

        for (int num : count) {
            answer.append(num).append("\n");
        }
        System.out.print(answer);
    }
}
