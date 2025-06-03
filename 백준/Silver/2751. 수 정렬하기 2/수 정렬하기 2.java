import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(bufferedReader.readLine()));
        }

        Collections.sort(numbers);

        for (int num : numbers) {
            stringBuilder.append(num).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
