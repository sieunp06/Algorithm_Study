import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            String input = bufferedReader.readLine();
            int count = 0;
            boolean isValid = true;

            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);

                if (c == '(') {
                    count++;
                } else {
                    if (count == 0) {
                        isValid = false;
                        break;
                    }
                    count--;
                }
            }

            if (isValid && count == 0) {
                stringBuilder.append("YES\n");
            } else {
                stringBuilder.append("NO\n");
            }
        }

        System.out.print(stringBuilder);
    }
}
