import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder input = new StringBuilder(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder answer = new StringBuilder();

        int index = 10;
        while (input.length() >= 10) {
            answer.append(input.substring(0, index)).append("\n");
            input.delete(0, index);
        }
        answer.append(input);
        System.out.println(answer);
    }
}
