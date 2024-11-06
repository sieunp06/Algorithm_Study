import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        List<Integer> numbers = new ArrayList<>();
        List<String> answer = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }

        int idx = 0;
        while (!numbers.isEmpty()) {
            idx += K - 1;
            while (idx >= numbers.size()) {
                idx -= numbers.size();
            }
            answer.add(String.valueOf(numbers.get(idx)));
            numbers.remove(idx);
        }

        System.out.println("<" + String.join(", ", answer) + ">");
    }
}