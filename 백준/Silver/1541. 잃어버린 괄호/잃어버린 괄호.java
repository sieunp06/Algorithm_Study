import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        Deque<Integer> numbers = new ArrayDeque<>();

        boolean isPlus = false;
        String number = "";
        for (char alpha : input.toCharArray()) {
            if (Character.isDigit(alpha)) {
                number += alpha;
                continue;
            }
            numbers.add(Integer.parseInt(number));
            number = "";

            if (isPlus) {
                numbers.add(numbers.pollLast() + numbers.pollLast());
            }

            if (alpha == '+') {
                isPlus = true;
                continue;
            }
            if (alpha == '-') {
                isPlus = false;
                continue;
            }
        }
        numbers.add(Integer.parseInt(number));
        if (isPlus) {
            numbers.add(numbers.pollLast() + numbers.pollLast());
        }

        int total = numbers.pollFirst();
        while (!numbers.isEmpty()) {
            total -= numbers.pollFirst();
        }
        System.out.println(total);
    }
}