import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] input = new BufferedReader(new InputStreamReader(System.in)).readLine().split("-");
        int[] numbers = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            String[] number = input[i].split("\\+");
            int sum = 0;
            for (String num : number) {
                sum += Integer.parseInt(num);
            }
            numbers[i] = sum;
        }

        int answer = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            answer -= numbers[i];
        }
        System.out.println(answer);
    }
}
