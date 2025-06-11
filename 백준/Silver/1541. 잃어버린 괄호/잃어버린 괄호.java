import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        String expression = bufferedReader.readLine();
        String[] subtractParts = expression.split("-");

        int result = sum(subtractParts[0]);

        for (int i = 1; i < subtractParts.length; i++) {
            result -= sum(subtractParts[i]);
        }

        System.out.println(result);
    }

    private static int sum(String part) {
        String[] numbers = part.split("\\+");
        int total = 0;
        for (String number : numbers) {
            total += Integer.parseInt(number);
        }
        return total;
    }
}
