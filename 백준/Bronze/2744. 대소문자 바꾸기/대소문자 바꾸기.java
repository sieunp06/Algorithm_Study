import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        StringBuilder stringBuilder = new StringBuilder();

        for (char alpha : input.toCharArray()) {
            if (Character.isLowerCase(alpha)) {
                stringBuilder.append(Character.toUpperCase(alpha));
                continue;
            }
            stringBuilder.append(Character.toLowerCase(alpha));
        }

        System.out.println(stringBuilder);
    }
}
