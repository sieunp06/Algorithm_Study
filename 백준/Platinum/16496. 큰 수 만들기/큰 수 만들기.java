import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int N = Integer.parseInt(bufferedReader.readLine());

        String[] numbers = bufferedReader.readLine().split(" ");
        Arrays.sort(numbers, (a, b) -> (b + a).compareTo(a + b));

        if (numbers[0].equals("0")) {
            System.out.println("0");
            return;
        }

        for (String number : numbers) {
            stringBuilder.append(number);
        }
        System.out.println(stringBuilder);
    }
}
