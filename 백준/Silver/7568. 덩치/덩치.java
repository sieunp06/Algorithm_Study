import java.io.*;
import java.util.*;
import java.util.stream.Collector;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int N;
    static Person[] person;

    static class Person {
        int weight, height;

        Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());

        person = new Person[N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int weight = Integer.parseInt(stringTokenizer.nextToken());
            int height = Integer.parseInt(stringTokenizer.nextToken());

            person[i] = new Person(weight, height);
        }
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (person[j].weight > person[i].weight && person[j].height > person[i].height) {
                    rank++;
                }
            }
            stringBuilder.append(rank).append(" ");
        }
    }
}
