import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        String numbers = bf.readLine();
        int answer = 0;

        for (char num : numbers.toCharArray()) {
            answer += num - '0';
        }

        System.out.println(answer);
    }
}