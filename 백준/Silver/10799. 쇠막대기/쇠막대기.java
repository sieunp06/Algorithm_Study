import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        int answer = 0;
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);

            if (target == '(') {
                count++;
            } else {
                if (input.charAt(i - 1) == '(') {
                    count--;
                    answer += count;
                } else {
                    count--;
                    answer += 1;
                }
            }
        }
        System.out.print(answer);
    }
}
