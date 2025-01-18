import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        List<String> answers = new ArrayList<>();
        Set<String> names = new HashSet<>();
        for (int i = 0; i < N + M; i++) {
            String name = bufferedReader.readLine();
            if (!names.contains(name)) {
                names.add(name);
                continue;
            }
            answers.add(name);
        }
        Collections.sort(answers);
        System.out.println(answers.size());
        for (String name : answers) {
            System.out.println(name);
        }
    }
}
