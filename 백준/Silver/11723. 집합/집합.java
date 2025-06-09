import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    private static int M;
    private static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        M = Integer.parseInt(bufferedReader.readLine());
        set = new HashSet<>();
        while (M-- > 0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();

            switch (command) {
                case "add": add(Integer.parseInt(stringTokenizer.nextToken())); break;
                case "remove": remove(Integer.parseInt(stringTokenizer.nextToken())); break;
                case "check": check(Integer.parseInt(stringTokenizer.nextToken())); break;
                case "toggle": toggle(Integer.parseInt(stringTokenizer.nextToken())); break;
                case "all": all(); break;
                default: empty();
            }
        }

        System.out.println(stringBuilder);
    }

    private static void empty() {
        set.clear();
    }

    private static void all() {
        set = new HashSet<>();
        for (int i = 1; i <= 20; i++) {
            set.add(i);
        }
    }

    private static void toggle(int target) {
        if (set.contains(target)) {
            set.remove(target);
            return;
        }
        set.add(target);
    }

    private static void check(int target) {
        if (set.contains(target)) {
            stringBuilder.append("1").append("\n");
            return;
        }
        stringBuilder.append("0").append("\n");
    }

    private static void add(int num) {
        set.add(num);
    }

    private static void remove(int target) {
        set.remove(target);
    }
}
