import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    static int num;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        flag = false;
        for (int i = 0; i < 3; i++) {
            String line = bufferedReader.readLine();

            char firstChar = line.charAt(0);
            if (firstChar != 'F' && firstChar != 'B') {
                num = Integer.parseInt(line);
                flag = true;
            }

            if (flag) {
                num++;
            }
        }
    }

    private static void solve() {
        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (num % 3 == 0) {
            System.out.println("Fizz");
        } else if (num % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(num);
        }
    }
}
