import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String input = bufferedReader.readLine();
        int[] alphabet = new int['z' - 'a' + 1];

        for (char alpha : input.toCharArray()) {
            alphabet[alpha - 'a']++;
        }

        for (int i = 0; i < alphabet.length; i++) {
            answer.append(alphabet[i]).append(" ");
        }
        System.out.print(answer);
    }
}
