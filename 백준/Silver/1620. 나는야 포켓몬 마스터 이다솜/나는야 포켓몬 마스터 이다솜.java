import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = bufferedReader.readLine();
            map1.put(String.valueOf(i), name);
            map2.put(name, String.valueOf(i));
        }

        for (int i = 0; i < M; i++) {
            String input = bufferedReader.readLine();
            if (map1.containsKey(input)) {
                stringBuilder.append(map1.get(input)).append("\n");
            } else {
                stringBuilder.append(map2.get(input)).append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
}
