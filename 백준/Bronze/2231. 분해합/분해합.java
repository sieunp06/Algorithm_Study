import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(bufferedReader.readLine());

        for (int i = 1; i <= num; i++) {
            int total = i;
            for (char alpha : String.valueOf(i).toCharArray()) {
                total += alpha - '0';
            }

            if (total == num) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
