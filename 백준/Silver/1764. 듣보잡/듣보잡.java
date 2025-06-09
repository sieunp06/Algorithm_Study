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

        Set<String> unheard = new HashSet<>();
        for (int i = 0; i < N; i++) {
            unheard.add(bufferedReader.readLine());
        }

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = bufferedReader.readLine();
            if (unheard.contains(name)) {
                answer.add(name);
            }
        }

        Collections.sort(answer);
        stringBuilder.append(answer.size()).append("\n");
        for (String name : answer) {
            stringBuilder.append(name).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
