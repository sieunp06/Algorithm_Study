import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int idx = 0;
        while (!list.isEmpty()) {
            idx = (idx + K - 1) % list.size();
            result.add(list.remove(idx));
        }

        stringBuilder.append("<");
        for (int i = 0; i < result.size(); i++) {
            stringBuilder.append(result.get(i));
            if (i != result.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(">");

        System.out.println(stringBuilder);
    }
}
