import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        while (true) {
            String input = bufferedReader.readLine();
            if (input.equals("0")) {
                break;
            }

            boolean flag = true;
            for (int i = 0; i < input.length() / 2; i++) {
                if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                stringBuilder.append("yes").append("\n");
            } else {
                stringBuilder.append("no").append("\n");
            }
        }

        System.out.println(stringBuilder);
    }
}
