import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bufferedReader.readLine();
        String input2 = bufferedReader.readLine();

        int[] alpha = new int['z' - 'a' + 1];

        for (char in1 : input1.toCharArray()) {
            alpha[in1 - 'a']++;
        }

        for (char in2 : input2.toCharArray()) {
            alpha[in2 - 'a']--;
        }

        int answer = 0;
        for (int a : alpha) {
            answer += Math.abs(a);
        }
        System.out.print(answer);
    }
}
