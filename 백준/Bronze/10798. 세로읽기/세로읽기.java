import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[][] alpha = new char[5][15];
        String answer = "";

        for (int i = 0; i < 5; i++) {
            char[] input = bf.readLine().toCharArray();

            for (int k = 0; k < input.length; k++) {
                alpha[i][k] = input[k];
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int k = 0; k < 5; k++) {
                if (alpha[k][i] != 0)
                    answer += alpha[k][i];
            }
        }

        System.out.println(answer);
    }
}