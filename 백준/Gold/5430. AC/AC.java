import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, n;
    static String p, input;
    static Deque<Integer> numbers;

    static boolean order;
    static boolean isError;

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            init();
            precess();
            printResult();
        }
        System.out.println(stringBuilder);
    }

    static void init() throws IOException {
        p = bufferedReader.readLine();
        n = Integer.parseInt(bufferedReader.readLine());

        numbers = new ArrayDeque<>();
        order = true;
        isError = false;

        input = bufferedReader.readLine();
        input = input.substring(1, input.length() - 1);
        String[] inputs = input.split(",");

        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(inputs[i]));
        }
    }

    static void precess() {
        for (char alpha : p.toCharArray()) {
            if (alpha == 'R') { // 배열의 순서 뒤집기
                order = !order;
            }
            if (alpha == 'D') { // 첫 번째 수 버리기
                if (numbers.isEmpty()) {
                    isError = true;
                    break;
                }
                if (order) {    // 정방향
                    numbers.pollFirst();
                } else {
                    numbers.pollLast();
                }
            }
        }
    }

    static void printResult() {
        if (isError) {
            stringBuilder.append("error").append("\n");
        } else {
            stringBuilder.append("[");
            while (!numbers.isEmpty()) {
                if (order) {
                    if (numbers.size() == 1) {
                        stringBuilder.append(numbers.pollFirst());
                    } else {
                        stringBuilder.append(numbers.pollFirst()).append(",");
                    }
                } else {
                    if (numbers.size() == 1) {
                        stringBuilder.append(numbers.pollLast());
                    } else {
                        stringBuilder.append(numbers.pollLast()).append(",");
                    }
                }
            }
            stringBuilder.append("]").append("\n");
        }
    }
}