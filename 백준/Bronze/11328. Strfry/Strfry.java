import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            int[] alphabet = new int['z' - 'a' + 1];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String input1 = stringTokenizer.nextToken();
            String input2 = stringTokenizer.nextToken();

            for (char ch : input1.toCharArray()) {
                alphabet[ch - 'a']++;
            }

            boolean possible = true;

            for (char ch : input2.toCharArray()) {
                alphabet[ch - 'a']--;
                if (alphabet[ch - 'a'] < 0) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                for (int count : alphabet) {
                    if (count != 0) {
                        possible = false;
                        break;
                    }
                }
            }

            if (possible) {
                stringBuilder.append("Possible").append('\n');
            } else {
                stringBuilder.append("Impossible").append('\n');
            }
        }

        System.out.print(stringBuilder);
    }
}
