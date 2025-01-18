import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            String input = bufferedReader.readLine();
            if (input.equals("0")) {
                break;
            }
            String text = input.substring(0, input.length() / 2);
            String reversed;
            if (input.length() % 2 == 0) {
                reversed = new StringBuilder(input.substring(input.length() / 2)).reverse().toString();
            } else {
                reversed = new StringBuilder(input.substring(input.length() / 2 + 1)).reverse().toString();
            }
            if (text.equals(reversed)) {
                stringBuilder.append("yes").append("\n");
                continue;
            }
            stringBuilder.append("no").append("\n");
        }
        System.out.println(stringBuilder);
    }
}
