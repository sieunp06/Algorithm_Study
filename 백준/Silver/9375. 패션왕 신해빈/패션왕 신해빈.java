import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(bufferedReader.readLine());

            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                String item = stringTokenizer.nextToken();
                String category = stringTokenizer.nextToken();

                map.put(category, map.getOrDefault(category, 0) + 1);
            }

            int result = 1;
            for (int count : map.values()) {
                result *= (count + 1);
            }

            stringBuilder.append(result - 1).append("\n");
        }

        System.out.print(stringBuilder);
    }
}
